package dynamicprogramming.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinCostClimbingStairs {

    class Solution {
     private int[] stairsCost;
     private Map<Integer, Integer> memo= new HashMap<Integer, Integer>();

     public int minCostClimbingStairsRecur(int[] cost) {
         this.stairsCost = cost;

         if(stairsCost.length == 1){
             return stairsCost[0];
         }else if(stairsCost.length == 2){
             return Math.min(stairsCost[0], stairsCost[1]);
         }else if(stairsCost.length == 3){
             return Math.min(stairsCost[0]+stairsCost[2], stairsCost[1]);
         }




         return  calculateMinCost(stairsCost.length-1);

     }

      private int calculateMinCost(int index){
         if(index == 0 || index == 1){
             memo.put(index, stairsCost[index]);
             return stairsCost[index];
         }

         //2,3,12,78,1
         if(!memo.containsKey(index)){

             if(index == stairsCost.length-1){
                  memo.put(index, Math.min(calculateMinCost(index-1), calculateMinCost(index-2)+stairsCost[index]));
             }else{
                   memo.put(index, Math.min(calculateMinCost(index-1)+stairsCost[index], calculateMinCost(index-2)+stairsCost[index]));
             }


         }
         return memo.get(index);
     }


        //10,15,20,0

        public int minCostClimbingStairsPureDP(int[] cost) {
            int n = cost.length+1;
            int[] memCost = new int[n];

            memCost = Arrays.copyOfRange(cost, 0, cost.length);


            for(int i = memCost.length -3 /* length-3 is to leave two elements after the current index that is in question*/; i>=0; i--){

                memCost[i] += Math.min(memCost[i+1], memCost[i+2]);
            }
            return Math.min(memCost[0],memCost[1]); // you can take step 0 or 1
        }




    }
}
