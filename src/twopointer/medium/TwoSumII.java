package twopointer.medium;

public class TwoSumII {
    /**
     * It is two pointer approach to calculate the sum
     *
     * Pay Attention if it is 1 -indexed
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {

        if(numbers.length == 0){
            return new int[0];
        }

        int l = 0;
        int r = numbers.length - 1;
        int sum = 0;
        while(l<r){
            sum = numbers[l]+numbers[r];

            if(sum == target){
                return new int[]{l+1,r+1};
            }
            else if(sum > target){
                r--;
            }else{
                l++;
            }
        }

        return new int[0];
    }
}
