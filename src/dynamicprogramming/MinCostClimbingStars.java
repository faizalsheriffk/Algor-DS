package dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class MinCostClimbingStars {

    //2,3,12,78,1
    private int[] stairsCost;
    private Map<Integer, Integer> memo= new HashMap<Integer, Integer>();

    public int minCostClimbingStairs(int[] cost) {
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
}
