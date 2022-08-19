package backtracking.medium;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    private int[] nums;
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {

        this.nums = nums;
        List<Integer> subSet = new ArrayList<Integer>();
        this.res.add(subSet);
        backTrack(subSet, -1);
        return this.res;

    }


    public void backTrack(List<Integer> sub, int index){

        for(int i = index+1; i<this.nums.length; i++){
            List<Integer> s = new ArrayList<Integer>();
            s.addAll(sub);
            s.add(nums[i]);
            this.res.add(s);
            backTrack(s, i);
        }
    }
}
