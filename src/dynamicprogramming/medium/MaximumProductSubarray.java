package dynamicprogramming.medium;

public class MaximumProductSubarray {


    public int maxProduct1(int[] nums) {

        int max = Integer.MIN_VALUE;

        int[] dp = new int[nums.length + 1];
        int[] minDp = new int[nums.length + 1];

        //sum with  0 integers is 0;
        dp[0] = 1;
        minDp[0] = 1;


        //recurrent relation is dp[index-1]*nums[i-1] >=0 ? Math.max(nums[i-1], nums[i-1]*dp[i-1]): Math.min(nums[i-1], nums[i-1]*dp[i-1])

        //

        for (int i = 1; i < dp.length; i++) {


            var positivePathNumMax = Math.max(nums[i - 1], nums[i - 1] * dp[i - 1]);
            var positivePathDpMax = Math.max(dp[i - 1], nums[i - 1] * dp[i - 1]);
            var positivePathMax = Math.max(positivePathNumMax, positivePathDpMax);

            var negativePathMax = minDp[i - 1] * nums[i - 1];
            dp[i] = Math.max(positivePathMax, negativePathMax);

            var negativePathNumMin = Math.min(nums[i - 1], nums[i - 1] * minDp[i - 1]);
            var negativePathDpMin = Math.min(minDp[i - 1], nums[i - 1] * minDp[i - 1]);
            var negativePathMin = Math.min(negativePathNumMin, negativePathDpMin);

            var positivePathMin = nums[i - 1] * dp[i - 1];
            minDp[i] = Math.min(negativePathMin, positivePathMin);
        }

        return dp[nums.length];
    }


    public int maxProduct2(int[] nums) {
        if (nums.length == 0) return 0;

        int max_so_far = nums[0];
        int min_so_far = nums[0];
        int result = max_so_far;

        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];

            // you are doing this because you need calculate min so far from previous
            int temp_max = Math.max(curr, Math.max(max_so_far * curr, min_so_far * curr));
            min_so_far = Math.min(curr, Math.min(max_so_far * curr, min_so_far * curr));

            max_so_far = temp_max;

            result = Math.max(max_so_far, result);
        }

        return result;
    }

    public int maxProduct3(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n1 = 0;//store postivie
        int n2 = 0;//store negative
        int ans = Integer.MIN_VALUE;
        for (int n : nums) {
            if (n == 0) {
                //Reset n1 and n2 to 0
                n1 = n2 = 0;
                //update ans when meet with 0 in nums
                ans = Math.max(ans, 0);
            } else if (n > 0) {
                //old_n1 = 0, then n1 = n
                //old_n1 > 0, then n1 = n1*n > 0
                n1 = n1 == 0 ? n : n1 * n;
                //old n2 = 0, then n2 = 0
                //old n2 < 0, then n2 = n2*n < 0
                n2 = n2 == 0 ? 0 : n2 * n;
            } else {
                //Deal with n < 0
                int old_n1 = n1;
                //old_n2 = 0, then n1 = 0
                //old_n2 < 0, then n1 = n*n2 > 0
                n1 = n2 == 0 ? 0 : n2 * n;
                //old_n1 = 0, then n2 = n < 0
                //old_n1 > 0, then n2 = n1*n
                n2 = old_n1 == 0 ? n : old_n1 * n;
            }
            //don't update ans when n1 and n2 = 0 (Default Value)
            if (n1 != 0) ans = Math.max(ans, n1);
            if (n2 != 0) ans = Math.max(ans, n2);
        }
        return ans;
    }
}
