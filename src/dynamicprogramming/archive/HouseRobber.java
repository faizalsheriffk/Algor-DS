package dynamicprogramming.archive;

import java.util.HashMap;
import java.util.Map;

public class HouseRobber {

    private int[] houses;

    private int maxBounty;

    private Map<Integer, Integer> memo = new HashMap<Integer, Integer>();


    public int calcMaxBounty(int[] house){
        this.houses = house;

        return calcMaxBounties(houses.length-1);
    }

    private  int calcMaxBounties(int index){


        if(index <= 0){
            maxBounty = houses[0];
            memo.put(0, maxBounty);
            return maxBounty;
        }

        if(index == 1){
            maxBounty = Math.max(houses[0], houses[1]);
            memo.put(1, maxBounty);
            return maxBounty;
        }



//        if(houses.length == 3){
//            maxBounty = Math.max((houses[0]+houses[2]), houses[1]);
//            memo.put(2, maxBounty);
//            return maxBounty;
//        }


        if(!memo.containsKey(index)) {
            maxBounty = maxBounty + Math.max( calcMaxBounties(index - 1), calcMaxBounties(index - 2) +houses[index]);
            memo.put(index, maxBounty);
        }

        return memo.get(index);

    }
}
