package dynamicprogramming.medium;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

        private int[] dp;

        public int lengthOfLIS(int[] nums) {
            this.dp = new int[nums.length+1];
            Arrays.fill(dp,1);

            for(int i = 1; i< nums.length; i++){
                for(int j = 0; j<i; j++){
                    if(nums[i] > nums[j]){
                        dp[i] = Math.max(dp[i], dp[j]+1);
                        //This can yield to wrong as you may have cases like this [0,1,0,3,2,3]
                        //dp[i] = dp[j]+1;
                    }
                }
            }


            int longest = 0;

            for(int i: dp){
                if(longest<i)
                    longest = i;
            }

            return longest;
        }

    }

