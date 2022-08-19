package backtracking.medium;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {

        permute(nums, new ArrayList<>());

        return result;
    }


    private void permute(int[] nums, List<Integer> permutations){



        for(int num: nums){
            if(permutations.contains(num)){
                continue;
            }
            List<Integer> tPermutations = new ArrayList<Integer>();
            tPermutations.addAll(permutations);
            tPermutations.add(num);
            if(tPermutations.size() == nums.length){
                result.add(tPermutations);
                return;
            }else{
                permute(nums, tPermutations);
            }

        }

    }
}
