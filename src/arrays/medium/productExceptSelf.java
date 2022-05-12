package arrays.medium;

public class productExceptSelf {

    /**
     * This is a O(N) in Time and O(1) in Space
     *
     * This is a unique algorithm and a technique to use output array to
     * store the intermediate value and use the output array + input array to
     * compute the final out put value
     *
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        if(nums.length == 0){
            return new int[0];
        }

        int[] out = new int[nums.length];
        int prefix=1, postfix = 1;

        //compute prefix

        out[0] = 1;
        for(int i=0; i<nums.length-1; i++){
            prefix = prefix*nums[i];
            out[i+1] = prefix;
        }

        //compute postfix;

        for(int i =nums.length-1; i>=0; i--){
            out[i] = out[i]*postfix;
            postfix = postfix*nums[i];
        }
        return out;
    }
}
