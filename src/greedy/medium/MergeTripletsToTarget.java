package greedy.medium;

import java.util.HashSet;
import java.util.Set;

public class MergeTripletsToTarget {


    //aways think the opposite
    //Your thought to match 1,2,3 element each row is good but that was negated by the row with higher values.
    //Think opposite: eliminate the rows with higher than target values
    public boolean mergeTriplets(int[][] triplets, int[] target) {

        int nr = triplets.length;
        int nc = triplets[0].length;

        int max = Integer.MIN_VALUE;
        Set<Integer> excluded = new HashSet<Integer>();


        for(int c = 0; c<nc; c++){

            for(int r = 0; r<nr; r++){
                if(triplets[r][c] > target[c]){
                    excluded.add(r);
                }
            }

        }


        for(int c = 0; c<nc; c++){

            for(int r = 0; r<nr; r++){

                if(excluded.contains(r)){
                    continue;
                }

                max = Math.max(max, triplets[r][c]);
            }

            if(max == target[c]){
                max = Integer.MIN_VALUE;
                continue;
            }else{
                return false;
            }

        }

        return true;
    }
}
