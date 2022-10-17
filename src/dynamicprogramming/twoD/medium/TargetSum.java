package dynamicprogramming.twoD.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 * This problem was difficult for me to understand as 1, 0 can be translated
 * to +1,+0 and also +1,-0
 */
public class TargetSum {

// This algorithm is good 23/127 cases it failed on 1,0
//     public int findTargetSumWays(int[] nums, int target) {

//         if(nums.length == 1){
//             if(nums[0] == target)
//             return target;
//                 else
//                     return 0;
//         }



//         int[][] grid = new int[nums.length+1][nums.length+1];

//         int combinations = 0;


//         for(int r = 1; r<grid.length; r++){
//             boolean isRowStart = true;
//             for(int c = 1; c<grid.length; c++){

//                 if(r == c){
//                     grid[r][c] = grid[r][c-1];
//                     continue;
//                 }

//                 if(isRowStart){
//                 grid[r][c] = grid[r][c-1]+(nums[r-1]*-1)+nums[c-1];
//                     isRowStart = false;
//                 }else{
//                     grid[r][c] = grid[r][c-1]+nums[c-1];
//                 }

//                 if(grid[r][c] == target){
//                     combinations++;
//                 }


//             }
//         }

//         return combinations;
//     }

        Map<String, Integer> map = new HashMap<String, Integer>();
        private int[] nums;
        private int target;
        private int sum;

        public int findTargetSumWays(int[] nums, int target) {

            sum = Arrays.stream(nums).sum();
            this.nums = nums;
            this.target = target;
            return dp(0,0); //index, sumVal

        }


        // i solved this algo with minimal help


        private int dp(int index, int sum){
            //base cases

            if(index >= nums.length){

                if(sum == target){
                    return 1;
                }else{
                    return 0;
                }
            }

//         if(sum == target){
//             return 1;
//         }

            String key = index+"_"+sum;

            if(map.containsKey(key)){
                return map.get(key);
            }
            //recur
            int combinations = dp(index+1, sum+nums[index])+dp(index+1, sum-nums[index]);

            map.put(key, combinations);

            return map.get(key);
        }
    }

// This failed for [1,0] 1

