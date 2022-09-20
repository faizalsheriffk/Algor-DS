package dynamicprogramming.archive;

import java.util.*;

public class DeleteAndEarn {


    private TreeMap<Integer, Integer> uniqueNum = new TreeMap<Integer, Integer>(new Comparator<Integer>() {
    @Override
    public int compare(Integer o1, Integer o2) {
        return o1-o2;
    }
});



    public int deleteAndEarn(int[] nums) {
        int ultimateMax = 0;
        int avoidedMax = 0;
        int usingMax = 0;
        int previous = -1;
        init(nums);

        //deleteAndEarn();
            //2->2, 3->3, 4-1

        for(Integer k: uniqueNum.keySet()){
            var val = uniqueNum.get(k)*k;
            ultimateMax = Math.max(avoidedMax, usingMax);
            if(k-1 != previous){
                usingMax = ultimateMax+val;
                avoidedMax = ultimateMax;
            }else{
                usingMax = avoidedMax+val;
                avoidedMax = ultimateMax;
            }

            previous = k;
        }

        return Math.max(avoidedMax, usingMax);
    }


    private void init(int[] nums){
        for(int i: nums){


            if(uniqueNum.containsKey(i)){
                int value = uniqueNum.get(i);
                uniqueNum.put(i, ++value);

            }else{
                uniqueNum.put(i, 1);
            }
        }
    }

}
