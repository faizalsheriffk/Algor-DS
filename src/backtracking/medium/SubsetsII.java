package backtracking.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {

    private List<List<Integer>> res = new ArrayList<>();
    private int[] sorted = null;

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);
        this.sorted = nums;

        List<Integer> emptySet = new ArrayList<Integer>();
        res.add(emptySet);

        computeSubsets(0,emptySet);

        return res;
    }

    private void computeSubsets(int index, List<Integer> subS){

        List<List<Integer>> watch = res;

        for(int i = index; i<sorted.length; i++){
            List<Integer> tSubs = new ArrayList<Integer>();
            tSubs.addAll(subS);
            tSubs.add(sorted[i]);
            res.add(tSubs);

            computeSubsets(i+1, tSubs);

            while((i+1) < sorted.length && sorted[i] == sorted[i+1]){
                i++;
            }



        }
    }
}
