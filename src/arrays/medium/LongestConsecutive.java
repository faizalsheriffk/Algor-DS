package arrays.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutive {
    /**
     * O(nlogn) in Time and O(1) in space
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {

        if(nums.length == 0){
            return 0;
        }

        Arrays.sort(nums);
        int max = 1;
        int cMax = 1;
        for(int i=0; i<nums.length-1; i++){
            if(nums[i] == nums[i+1]){
                continue;
            }
            else if(nums[i]+1 == nums[i+1] ){
                cMax++;
                max = Math.max(cMax,max);
            }else{
                cMax = 1;
            }

        }

        return max;
    }

    /**
     * O(N) in Tine
     * O(N) in space
     *
     * There is an interesting pattern here, you fix one constraint here like
     * Set can't have n-1 in it and explore/loop the n+1 to calculate the longest sub sequence
     * or
     * Set can't have n+1 in it and explore/loop the n-1 to calculate the longest sub sequence
     * @param nums
     * @return
     */
    public int longestConsecutiveFaster(int[] nums) {

        if(nums.length == 0){
            return 0;
        }

        //populate hashset
        Set<Integer> set = new HashSet<Integer>();

        for(Integer n: nums){
            set.add(n);
        }
        int currentNum = 0;
        int cMax=1;
        int max=1;

        for(Integer n: set){

            if(!set.contains(n-1)){
                currentNum = n;
                while(set.contains(currentNum+1)){
                    currentNum++;
                    cMax++;

                }
                max = Math.max(cMax, max);
                cMax = 1;
            }
        }

        return max;
    }

}
