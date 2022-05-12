package arrays.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {

        if(nums.length == 0){
            return new int[0];
        }else if (nums.length == 1 && k == 1){
            return new int[]{nums[0]};
        }

        Arrays.sort(nums);

        int prev = nums[0];
        int counter = 0;
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 1; i<nums.length; i++){
            if(prev == nums[i]){
                counter++;
            }else{
                //don't set the counter to zero
                counter = 1;
            }

            if(counter >= k){
                set.add(nums[i]);
            }

            prev = nums[i];
        }

        //Creating an empty integer array
        int[] array = new int[set.size()];
        int j = 0;
        for(int i:set){
            array[j] = i;
            j++;
        }

        return array;
    }
}
