package dynamicprogramming.medium;

import java.util.Arrays;

public class CoinChange {

    // It is unbounded knap sack problem.

    public int coinChange(int[] coins, int amount) {

        if(amount == 0){
            return 0;
        }


        int[] dp = new int[amount+1];

        Arrays.fill(dp, amount+1);

        Arrays.sort(coins);

        dp[0] = 0;
        // we can't set this base case as dp[1] may be -1
//         dp[1] = 1+dp[0];

        for(int currentAmount = 0; currentAmount< dp.length; currentAmount++){
            for(int j=0; j<coins.length; j++){

                if(currentAmount-coins[j] < 0){
                    break;
                }

                dp[currentAmount] = Math.min(dp[currentAmount], 1+dp[currentAmount-coins[j]]);
            }
        }

        return dp[amount] != (amount+1)?dp[amount]:-1;
    }
}
