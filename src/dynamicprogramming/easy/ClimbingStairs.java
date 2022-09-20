package dynamicprogramming.easy;


// First Step is to draw the decision tree
// Set up recurrence relation, identify the state variables.
// come up with a recurrence solution top down - memoization




public class ClimbingStairs {

    private int count = 0;
    private int tSteps = 0;
    private int memo[];

    /**
     * This is the recursive approach with memoization, less efficient
     * @param n
     * @return
     */
    public int climbStairs(int n) {

        this.tSteps = n;
        this.memo = new int[n+1];

        if(n == 1){
            count++;
            return 1;
        }

        return dp(0);
    }


    private int dp(int stepNo){

        if(stepNo == tSteps){
            return 1;
        }


        if(stepNo > tSteps){
            return 0;
        }

        //actual memoization
        if(memo[stepNo] > 0){
            return memo[stepNo];
        }

        this.memo[stepNo] = dp(stepNo+1)+dp(stepNo+2);

        return this.memo[stepNo];
    }

    /**
     * This is the pure DP
     * @param n
     * @return
     */
    public int climbStairsPureDP(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
