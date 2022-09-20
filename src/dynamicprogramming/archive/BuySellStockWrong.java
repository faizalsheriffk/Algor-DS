package dynamicprogramming.archive;

import java.util.Arrays;

public class BuySellStockWrong {

    private int[] dp;
    private int[] prices;

    public int maxProfit(int k, int[] prices) {
        dp = new int[prices.length];
        this.prices = prices;

        Arrays.fill(dp, -1);
        int maxProfit = 0;
        var max = 0;
        var val = 0;
        //single pass to find the max buy sell days
        for(int i =0; i<prices.length; i++){
            max = Integer.MIN_VALUE;
            for(int j=i+1; j<prices.length; j++){
                val = prices[j] - prices[i];
                if(max<val){
                    max = val;
                    dp[i] = j;

                }
            }

        }

        for(int i =0; i<dp.length; i++){
            maxProfit = Math.max(maxProfit, dp(i, k));
        }

        return maxProfit;

    }

    private int dp(int i, int transCnt){
        transCnt--;
        if(transCnt<0 || i >= dp.length || i >= prices.length ||  dp[i]>=prices.length || dp[i]<0)
            return 0;

        var profit = prices[dp[i]]-prices[i];

        for(int j = dp[i]+1; j<dp.length; j++){
            profit = Math.max(profit, profit+dp(j, transCnt));
        }
        return profit;
    }
}
