package twopointer.hard;

public class TrappingRainWater {

    /**
     * The idea here unlike Contains with most water problem, the height with whihc you can hold water is
     * not fixed so at each level we find how much we can trap keeping track of minimum of max(left) and  max(right)
     * as you are aware you are limited by the lowest boundary.
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {

        if(height.length == 0){
            return 0;
        }

        int leftMax = 0;
        int rightMax = 0;
        int ans = 0;
        int left = 0;
        int right = height.length -1;

        while(left < right){

            if(height[left] <= height[right]){

                leftMax = Math.max(leftMax, height[left]);
                ans += leftMax - height[left];

                left++;
            }else{
                rightMax = Math.max(rightMax, height[right]);
                ans += rightMax - height[right];

                /**
                 * key is reduce the right
                 */
                right--;
            }
        }

        return ans;
    }

}
