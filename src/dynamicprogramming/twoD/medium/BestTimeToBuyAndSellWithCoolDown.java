package dynamicprogramming.twoD.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * This problem was difficult for me
 */
public class BestTimeToBuyAndSellWithCoolDown {

        // This problem I am still not clear

        Map<String, Integer> dpMap = new HashMap<String, Integer>();

        public int maxProfit(int[] prices) {

            // it is three state problem but we can comprise this to two state
            //return dp(0, prices, true);

            int bought = Integer.MIN_VALUE;
            int sold = Integer.MIN_VALUE;
            int cleanState = 0; // this is important don't set it to zero
            for(int price:prices){
                int previousSold = sold;
                bought = Math.max(bought, cleanState-price);
                cleanState = Math.max(cleanState, previousSold); // collect profits or remainsame
                sold = bought+price;

            }
            return Math.max(cleanState, sold);
        }

        private int dp(int i, int[] prices, boolean isBuying){

            if(i >= prices.length){
                return 0;
            }

            String key = i+"_"+isBuying;

            //How are we making sure the dpMap has the maximium value?
            //It is the recursive approach

            if(dpMap.containsKey(key))
                return dpMap.get(key);

            //This line is a code optimization but it is more clear here
            // int coolDownDayProfit = dp(i+1, prices, isBuying); //no change in state
            int coolDownDayProfit = 0;

            int buyOrSellDayProfit = Integer.MIN_VALUE;

            if(isBuying){
                buyOrSellDayProfit = dp(i+1, prices, !isBuying)-prices[i]; // it is a cost
                coolDownDayProfit = dp(i+1, prices, isBuying);
            }else{
                buyOrSellDayProfit = dp(i+2, prices, !isBuying)+prices[i]; // it is a profit
                coolDownDayProfit = dp(i+1, prices, isBuying);
            }

            //as we can't do both buy and sell on the same day we pick between one of the events
            //we executed and coolDay

            dpMap.put(key, Math.max(coolDownDayProfit, buyOrSellDayProfit));

            return dpMap.get(key);


        }

    }

//

//             buy         cooldown

//        sell cool        buy cool

//        cool sell cool

//       buy
//     1 -1b
//     2  1s -1c
//     3  2s 1c
//     0  1b 2c
//     2  3s -2b
// bought[i] = max(bough[i-1],cleanSlate[i-1]-prices[i];
// cleanSlate[i] = Math.max(bought[i-1], sold[i-1]); // previous clean slate and previous slate+sell as previous slate+buy will always yeild negative
//sold[i] = bought[i-1] + prices[i];

//Math.max(sold[l-1],cleanslate[l-1])

// b = -1
// c =  0,0 = 0
// s = 0

// b = -2
// c =  0
// s = 1

// b = -3
// c = 1
// s = 1

// b = 1
// c = 1
// s = -3

// b = -1
// c = 1
// s =



