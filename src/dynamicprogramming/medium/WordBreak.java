package dynamicprogramming.medium;

import java.util.Arrays;
import java.util.List;

public class WordBreak {
    private String s;
    private List<String> wordDict;
    private int[] memo;

    private boolean dp(int i) {
        if (i < 0) return true;

        if (memo[i] == -1) {
            for (String word: wordDict) {
                if (i >= word.length() - 1 && dp(i - word.length())) {
                    if (s.substring(i - word.length() + 1, i + 1).equals(word)) {
                        memo[i] = 1;
                        break;
                    }
                }
            }
        }

        if (memo[i] == -1) {
            memo[i] = 0;
        }

        return memo[i] == 1;
    }

    public boolean wordBreakRecursive(String s, List<String> wordDict) {
        this.s = s;
        this.wordDict = wordDict;
        this.memo = new int[s.length()];
        Arrays.fill(this.memo, -1);
        return dp(s.length() - 1);
    }

    public boolean wordBreakIterativeBottomUp(String s, List<String> wordDict) {

        boolean[] dp = new boolean[s.length()+1];

        dp[s.length()] = true;
        for(int i = s.length()-1; i>-1; i--){

            for(String word:wordDict){

                if(i+word.length() <= s.length() && s.substring(i, i+word.length()).equals(word)){

                    // This is the recurrence relation
                    dp[i] = dp[i+word.length()];


                    if(dp[i])
                        break;

                }else{
                    continue;
                }
            }
        }

        return dp[0];
    }


    public boolean wordBreakIterativeTopDown(String s, List<String> wordDict) {

        boolean[] dp = new boolean[s.length()+1];

        dp[0] = true;
        //Top down i<=s.length() is critical as there are some boundary conditions
        for(int i = 0; i<=s.length(); i++){

            for(String word:wordDict){

                if(i-word.length() >= 0 && s.substring (i-word.length(),i).equals(word)){

                    // This is the recurrence relation
                    dp[i] = dp[i-word.length()];


                    if(dp[i])
                        break;

                }else{
                    continue;
                }
            }
        }

        return dp[s.length()];
    }






}