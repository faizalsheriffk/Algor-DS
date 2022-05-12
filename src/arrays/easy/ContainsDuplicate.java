package arrays.easy;

import java.util.Arrays;
import java.util.HashSet;

public class ContainsDuplicate {


    public boolean containsDuplicate(int[] nums) {

        if (nums.length == 0) {
            return false;
        }

        return containsDuplicateBySort(nums);
    }

    /**
     * NLOG N Solution
     * @param nums
     * @return
     */
    private boolean containsDuplicateBySort(int[] nums) {

        if(nums.length == 0){
            return false;
        }

        //nlogn solution - quick sort
        Arrays.sort(nums);

        for(int i = 0; i<nums.length-1; i++){
            if(nums[i]==nums[i+1]){
                return true;
            }
        }

        return false;
    }

    /**
     * O(N) in SPACE
     * o(N) in TIME
     * @param nums
     * @return
     */
    private boolean ContainsDuplicateBySet(int[] nums){

        HashSet<Integer> set = new HashSet<Integer>();

        for(int i = 0; i < nums.length; i++){
            if(set.add(nums[i])){
                return true;
            }
        }
        return false;
    }
}
