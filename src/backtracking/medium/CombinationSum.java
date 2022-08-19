package backtracking.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

    private int[] sortedCandidates;
    // private Set<List<Integer>> res = new HashSet<>();
    private List<List<Integer>> res = new ArrayList<>();


    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        Arrays.sort(candidates);
        this.sortedCandidates = candidates;

        backTrack(new ArrayList<Integer>(), 0, 0, target);

        // return res.stream().collect(Collectors.toList());
        return res;
    }


    private void backTrack(List<Integer> combination, int index, int curSum, int target){

        for(int i = index; i<this.sortedCandidates.length; i++){
            var num = this.sortedCandidates[i];
            var tSum = curSum+num;
            var diff = tSum - target;
            List<Integer> tComb = new ArrayList<Integer>();
            tComb.addAll(combination);

            if(diff == 0){
                tComb.add(num);
                // Collections.sort(tComb);
                res.add(tComb);
                return;
            }else if(diff < 0){
                tComb.add(num);
                backTrack(tComb, i, tSum, target);
            }else{
                return;
            }

        }
    }
}
