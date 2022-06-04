package binarySearch.medium;

public class FindMinimumInRotatedSortedArray {

    public int findMin(int[] nums) {

        int start = 0;
        int end = nums.length-1;

        if(nums.length == 1){
            return nums[0];
        }

        if(nums[start] < nums[end]){
            //already sourted
            return nums[start];
        }


        while(start<=end){


            var middle = (start+end) / 2;

            if(nums[middle] > nums[middle+1]){
                return nums[middle+1];
            }else{
                /**
                 * Do not confuse this with binary saerch operation, here the goal is
                 * to find where the ascending values start descending
                 * who can tell you the exactly which direction to head towards
                 */
                if(nums[middle] < nums[start]){
                    end = middle -1;
                }else{
                    start = middle+1;
                }
            }

        }
        return nums[0];
    }
}
