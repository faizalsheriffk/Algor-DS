package dynamicprogramming.twoD.medium;

import java.util.HashMap;
import java.util.Map;

public class CoinChangeII {


    private Map<String,Integer> dpMap = new HashMap<String, Integer>();
    private int amount;
    private int[] coins;

    public int change(int amount, int[] coins) {
        // this.amount = amount;
        // this.coins = coins;
        // return dp(0, 0);


        //tabulation approach
        //
/*      0 1 2 3 4 5
      1 1 1 2 2 3 4
      2 1 0 1 0 1 1
      5 1 0 0 0 0 1
      0 1 0 0 0 0 0
      */

        int row = coins.length+1;
        int col = amount+1;
        int[][] grid = new int[row][col];

        for(int r = 0; r<row; r++){
            grid[r][0] = 1;
        }

        for(int r = row-2; r>=0; r--){
            for(int c = 1; c<col; c++){

                grid[r][c] = grid[r+1][c];
                var val = c-coins[r];
                if(val >=0){
                    grid[r][c] = grid[r][c]+grid[r][val];
                }
            }
        }

        return grid[0][amount];
    }


    private int dp(int a, int i){

        if(a == amount){
            return 1;
        }

        if(a>amount){
            return 0;
        }

        if(i>=coins.length){
            return 0;
        }


        String key = i+"-"+a;

        if(dpMap.containsKey(key)){
            return dpMap.get(key);
        }


        int combinations = dp(a+coins[i], i)/*repeat same coin infinite times to get the amount*/ + dp(a, i+1);

        dpMap.put(key, combinations);

        return dpMap.get(key);
    }
}