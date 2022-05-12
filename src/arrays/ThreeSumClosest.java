package arrays;

import java.util.Arrays;

public class ThreeSumClosest {

    public static void main(String args[]){
        int[] nums = {1,1,1,1};
        System.out.print(new ThreeSumClosest().threeSumClosest(nums,3));
    }

    public int threeSumClosest(int[] nums, int target) {

        if(nums.length < 3 ){
            return 0;
        }

        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE;
        int sum, diff = 0;

        //nums[i]<=target does work in local but not in leetecode
        for(int i = 0; i<nums.length && nums[i]<=target; i++){

            if(i == 0 || nums[i-1]!=nums[i]){
                diff = computeThreeSum(i, nums, target);
                if(Math.abs(diff) < Math.abs(minDiff)){
                    minDiff = diff;
                }
            }
        }

        return target-minDiff; //sum
    }

    private int computeThreeSum(int i, int[] nums, int target){
        int l = i+1;
        int r = nums.length -1;
        int sum, diff = 0;
        int minDiff = Integer.MAX_VALUE;

        while(l<r){
            sum = nums[i]+nums[l]+nums[r];
            diff = target - sum;

            if(Math.abs(diff)<Math.abs(minDiff)){
                minDiff = diff;
            }
            if(sum < target){
                l++;
                //additional enhancement
                while (l<nums.length && nums[l-1] == nums[l]){
                    l++;
                }
            }else{
                r--;

                //additional enhancement
                while (r>0 && nums[r+1] == nums[r]){
                    r--;
                }
            }
        }
        return minDiff;
    }
}
