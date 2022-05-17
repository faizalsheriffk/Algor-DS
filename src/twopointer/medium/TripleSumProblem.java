package twopointer.medium;

import java.util.*;

public class TripleSumProblem {
    /**
     * The idea here in this algorithm is to reduce O(N3) to O(N2).
     * How do we do it?
     * Sort the entire array so that you have some definite order
     * it introduces nlogn in time, but that's fine
     * You fix one item in the array and iterate the second item and third item
     * in the very outermost loop, if you see an identical element skip
     * in the second item loop, if you see an identical element skip
     * Offcourse, when you find a sum of item1, item2 and item3 = 0, you move second identical item
     * You have a choice to skip item 2 or ttem 3 when they are identical in the inner looop.
     * Caveat is make sure, you pick one either second or third and use only one item to skip if they
     * identical and alter the nums[l(second item)-1] == nums [l(second item)] vs nums[r+1] == nums[r]
     * Time Complexity is O(N2)+O(NLOGN) = O(N2)
     * @param nums
     * @return
     */

    public List<List<Integer>> threeSumTwoPointer(int[] nums) {
            Arrays.sort(nums);

            List<List<Integer>> res = new ArrayList<>();
            /**
             * This is very critical nums[i] <= 0 or target as it reduces the loops that it has to run
             */
            for (int i = 0; i < nums.length && nums[i] <= 0; ++i)
            /**
             * This if loops is critical if it is not there TLE might show up
             */
                if (i == 0 || nums[i - 1] != nums[i]) {
                    twoPointerThreeSum(nums, i, res);
                }
            return res;
        }

    /**
     * Three sum no sort solution
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSumNoSort(int[] nums) {

        if(nums == null || nums.length <3){
            return new ArrayList();
        }

        Set<Integer> dups = new HashSet<Integer>();

        Map<Integer, Integer> seenMap = new HashMap<Integer, Integer>();
        Set<List<Integer>> resSet = new HashSet<>();
        int complement = 0;

        for(int i=0; i<nums.length; i++){

            //proceed only if it is not there
            if(dups.add(nums[i])){
                for(int j = i+1; j<nums.length; j++){
                    complement = -(nums[i]+nums[j]);

                    //real magic happens here
                    if(seenMap.containsKey(complement) &&  seenMap.get(complement) == i){
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], complement);
                        Collections.sort(triplet);
                        resSet.add(triplet);

                    }

                    //key is to map it to the index i and not the value of i
                    seenMap.put(nums[j], i);

                }

            }
        }

        List<List<Integer>> resL = new ArrayList<>(resSet);
        return resL;
    }



    private void twoPointerThreeSum(int[] nums, int i, List<List<Integer>> res) {
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum < 0) {
                    ++l;
                    /**
                     * Additional Optimization
                     */
                    while( l< r && nums[l-1] == nums[l]){
                        l++;
                    }
                } else if (sum > 0) {
                    --r;
                } else {
                    /**
                     * l++ and r-- is important
                     */

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
