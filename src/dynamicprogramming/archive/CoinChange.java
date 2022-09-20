package dynamicprogramming.archive;


import java.util.Arrays;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {

        // if(coins.length == 0 || amount <= 0){
        //     return -1;
        // }

        int[] dpTab = new int[amount+1];
        Arrays.fill(dpTab, amount+1);

        //base cases
        dpTab[0] = 0;


        //2,5,7

        Arrays.sort(coins);



        for(int i = 0; i<= amount; i++){
            for(int j=0; j<coins.length; j++){

                if(i - coins[j] < 0){
                    break;
                }
                dpTab[i] = Math.min(dpTab[i], 1+dpTab[i-coins[j]]);
            }
        }
        return dpTab[amount] != (amount+1)? dpTab[amount]:-1;

    }


}