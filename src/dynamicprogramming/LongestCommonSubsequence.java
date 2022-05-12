package dynamicprogramming;

import java.util.ArrayList;
import java.util.LinkedHashSet;

public class LongestCommonSubsequence {

    private int[][] memo = null;
    private int count = 0;
    public int longestCommonSubsequence(String text1, String text2) {


        char[] left = text1.toCharArray();
        char[] right = text2.toCharArray();
        int lIndex = 0;
        int rIndex = 0;
        memo = new int[left.length][right.length];

        return lCS(left, right, 0, 0);

    }

    private int lCS(char[] left, char[] right, int l, int r){

        //base condition
        if(l>=left.length || r>=right.length){
            return 0;
        }
        //utilizing memo
        if(memo[l][r] > 0){
            return memo[l][r];
        }
        if(left[l] == right[r]){
            count++;
            //don't use l++, r++ as it increases the l and r here
            memo[l][r] = 1+lCS(left, right, l+1, r+1);
        }else{

            //recurrence relation
            memo[l][r] = Math.max(lCS(left, right, l+1, r),
                    lCS(left, right, l, r+1));
        }



        return memo[l][r];
    }
}
