package twopointer.medium;

public class ContainsWithMostWater {

    public int maxArea(int[] height) {

        if(height.length<2){
            return 0;
        }

        int maxArea = Integer.MIN_VALUE;
        int l = 0;
        int r = height.length-1;

        while(l<r){
            //Careful on the diff calculation r-l will give you the correct
            //difference. No need to increment one
            var diff = r-l;
            var m = Math.min(height[l], height[r]) * diff;
            maxArea = Math.max(maxArea, m);

            if(height[l]-height[r] > 0){
                r--;
            }else{
                l++;
            }
        }
        return maxArea;
    }
}
