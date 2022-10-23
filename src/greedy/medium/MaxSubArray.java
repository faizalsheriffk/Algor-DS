package greedy.medium;

public class MaxSubArray {

    public int maxSubArray(int[] nums) {

        int max = nums[0];
        int currentSum = nums[0];

        for(int i=1; i<nums.length; i++){
            currentSum = Math.max(currentSum + nums[i], nums[i]);
            max = Math.max(max, currentSum);
            // if(currentSum > max){
            //     if(nums[i] > max){
            //      max = nums[i];
            //      currentSum = nums[i];
            //     }else{
            //         max = currentSum;
            //     }
            // }
        }

        return max;
    }
}
