package arrays.easy;

import java.util.HashMap;

public class TwoSum {

    /**
     * O(N2)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {

        int[] answer = new int[2];
        for(int i = 0; i<nums.length-1; i++){

            for(int j = i+1; j<nums.length; j++){

                if(nums[i] + nums[j] == target){

                    answer[0] = i;
                    answer[1] = j;

                    return answer;
                }
            }
        }

        return answer;
    }

    /**
     *  O(N) Singles Pass Solution
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSumOnePass(int[] nums, int target) {

        int[] answer = new int[2];


        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int complement = 0;

        for(int i = 0; i< nums.length; i++){
            complement = target - nums[i];

            if(map.containsKey(complement) && map.get(complement)!= i){
                answer [0] = i;
                answer [1] = map.get(complement);
                return answer;
            }

            map.put(nums[i], i);

        }

        return answer;
    }

}
