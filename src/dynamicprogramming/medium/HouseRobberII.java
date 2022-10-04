package dynamicprogramming.medium;

public class HouseRobberII {

    /**
     * All are based of of Fib
     * @param nums
     * @return
     */

    public int rob(int[] nums) {

        //int[] mem = new int[nums.length];

        if(nums.length == 0){
            return 0;
        }

        if(nums.length == 1){
            return nums[0];
        }

        int rob1 = 0, rob2 = 0;
        for(int i = 0; i<nums.length-1; i++){
            var temp = Math.max(rob1+nums[i], rob2);
            rob1 = rob2;
            rob2 = temp;
        }

        var firstHouseMayRobbedMax = rob2;

        rob1 = 0;
        rob2 = 0;

        for(int i = 1; i<nums.length; i++){
            var temp = Math.max(rob1+nums[i], rob2);
            rob1 = rob2;
            rob2 = temp;
        }

        var lastHouseMayRobbedMax = rob2;

        return Math.max(firstHouseMayRobbedMax, lastHouseMayRobbedMax);
    }
}
