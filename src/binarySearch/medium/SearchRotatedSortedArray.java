package binarySearch.medium;

public class SearchRotatedSortedArray {

    public int search(int[] nums, int target) {

        if(nums.length == 0)
            return -1;

        if(nums.length == 1){
            return nums[0] == target? 0 : -1;
        }

        int rotatedIndex = findRotatedIndex(nums);

        if(target == nums[rotatedIndex]){
            return rotatedIndex;
        }

        if(rotatedIndex == 0){
            //the array is not rotated
            return search(0, nums.length-1, nums, target);
        }else{

            /**
             * The given condition is that the array is in
             * ascending order so since it is rotated it is on the
             * opposite direction
             */

            if(target < nums[0]){
                return search(rotatedIndex, nums.length-1, nums, target);
            }else{
                return search(0, rotatedIndex-1, nums, target);
            }
        }

    }

    private int findRotatedIndex(int[] nums){

        int start = 0;
        int end = nums.length-1;

        if(nums[start] < nums[end]){
            //already sourted
            return start;
        }


        while(start<=end){


            var middle = (start+end) / 2;

            if(nums[middle] > nums[middle+1]){
                return middle+1;
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
        return 0; //how?

    }


    private int search(int start, int end, int[] nums, int target){


        while(start<=end){

            var middle = (start+end)/2;

            if(nums[middle] == target){
                return middle;
            }else if(target > nums[middle]){

                start = middle+1;
            }else{

                end = middle -1;
            }


        }
        return -1;
    }
}
