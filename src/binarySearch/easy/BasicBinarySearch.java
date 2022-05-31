package binarySearch.easy;

public class BasicBinarySearch {

    public int search(int[] nums, int target) {

        return binarySearch(nums, 0, nums.length-1, target);

    }


    private int binarySearch(int[] nums, int start, int end, int target){

        if(end<=start){

            if(nums[end] == target)
                return end;
            else
                return -1;
        }

        int middle = start+ ((end -start)/2);

        if(nums[middle] == target){
            return middle;
        }

        if(target < nums[middle]){
            return binarySearch(nums, start, middle, target);
        }else{
            return binarySearch(nums, middle+1, end, target);
        }


    }

    public static void main(String[] args){
        int[] nums = new int[]{-1,0,3,5,9,12};
        new BasicBinarySearch().search(nums, 9);
    }
}
