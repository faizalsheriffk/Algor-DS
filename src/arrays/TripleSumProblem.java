package arrays;

import java.util.*;

public class TripleSumProblem {


        public List<List<Integer>> threeSumTwoPointer(int[] nums) {
            Arrays.sort(nums);

            List<List<Integer>> res = new ArrayList<>();
            for (int i = 0; i < nums.length && nums[i] <= 0; ++i)
                if (i == 0 || nums[i - 1] != nums[i]) {
                    twoPointerThreeSum(nums, i, res);
                }
            return res;
        }
        private void twoPointerThreeSum(int[] nums, int i, List<List<Integer>> res) {
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum < 0) {
                    ++l;
                } else if (sum > 0) {
                    --r;
                } else {
                    res.add(Arrays.asList(nums[i], nums[l++], nums[r--]));
                    while (l < r && nums[l] == nums[l - 1])
                        ++l;
                }
            }
        }

        //T O(N2) S O(N)
        private void hashSetApproach(int[] nums, int i, List<List<Integer>> res){
            Set<Integer> visited = new HashSet<Integer>();
            int compliment = 0;

            for(int j=i+1; j<nums.length; j++){
                compliment = - (nums[i]+nums[j]);

                if(visited.contains(compliment)){
                    res.add(Arrays.asList(nums[i], nums[j], compliment));
                    //move the index to the next unique one
                    while(j+1 < nums.length && nums[j] == nums[j+1] ){
                        j++;
                    }
                }
                visited.add(nums[j]);
            }
        }

}
