package dynamicprogramming.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *
 */
public class PartitionEqualSubsetSum {

    public boolean canPartition(int[] nums) {

        var sum = Arrays.stream(nums).sum();

        if(sum%2 != 0){
            return false;
        }

        var target = sum/2;

        Set<Integer> dpSet = new HashSet<Integer>();
        dpSet.add(0);
        for(int num: nums){

            Set<Integer> tempSet = new HashSet<Integer>();
            tempSet.addAll(dpSet);

            for(int i:dpSet){

                var s = num+i;

                if(s == target)
                    return true;

                tempSet.add(s);
            }
            dpSet = tempSet;
        }

        return dpSet.contains(target);
    }
}
