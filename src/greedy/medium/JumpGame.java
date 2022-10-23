package greedy.medium;

public class JumpGame {

    /**
     *I was able to come up with this solution
     */
    public boolean canJump(int[] nums) {

//         int startIndex = 0;
//         int distance = 0;
//         int currentMax = nums[0];
//         for(int i = 1; i<nums.length; i++){

//             startIndex = i;
//             endIndex = currentMax;
//             for(int j = startIndex; j<=endIndex && j<nums.length; j++){
//                 if(nums[j] > currentMax){
//                    //                     distance += currentMax
//                     currentMax = nums[j];
//                     break;
//                 }
//             }
//         }

//         return distance >= nums.length?true:false;

        int currentDistance = nums[0];
        for(int i = 1; i<=currentDistance && i<nums.length; i++){

            currentDistance = Math.max(i+nums[i], currentDistance);

            if(currentDistance >= nums.length-1){
                return true;
            }
        }

        return currentDistance >= nums.length-1?true:false;
    }
}
