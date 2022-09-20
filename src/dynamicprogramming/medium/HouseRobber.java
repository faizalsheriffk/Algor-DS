package dynamicprogramming.medium;

// First Step is to draw the decision tree
// Set up recurrence relation
// come up with a recurrence solution top down - memoization

//
//     0        1
//  0+2  0+3     1+2 1+3
// Approach 1
// Recurrence

import java.util.Arrays;

class HouseRobberRecursive {
     private int[] memo;
     public int rob(int[] nums) {
        memo = new int[nums.length];

        //fill it with some predefined value
        Arrays.fill(memo, -1);

       //recurrence relation
       // mem[i] = MAX(rob(i+2, nums)+nums[i], rob(i+1, nums))
        return robFrom(0, nums);
     }


     private int robFrom(int position, int[] nums){

         if(position >= nums.length){
             return 0; // base case
         }

         if(memo[position] != -1){
             return memo[position];
         }
         memo[position] = Math.max(robFrom(position+1, nums), robFrom(position+2, nums)+nums[position]);

         return memo[position];
     }
 }


// Efficient approach
// DP
// I implemented this following the concept that is in my head applying the same recurrence relation
// this is very good
class HouseRobberDpTabulation {
    public int rob(int[] nums) {

        int len = nums.length;

        int[] mem = new int[len];

        // initialize the base cases


        if(nums.length == 0){
            return 0;
        }else if(nums.length == 1){
            return nums[0];
        }else if(nums.length == 2){
            return Math.max(nums[0],nums[1]);
        }


//         mem = Arrays.copyOfRange(nums, 0, nums.length);

        mem[0] = nums[0];
        mem[1] = Math.max(nums[0],nums[1]);

        for(int j = 2; j<nums.length; j++){

            mem[j] = Math.max(mem[j-2]+nums[j], mem[j-1]);
        }

        return mem[len-1];
    }
}


//Much more Efficient Approach
//This is an approach further optimizing where you don't need addition space. With O(2) = O(1)

public class HouseRobber {
     public int rob(int[] nums) {

         int len = nums.length;



          // initialize the base cases


         if(nums.length == 0){
             return 0;
         }else if(nums.length == 1){
             return nums[0];
         }else if(nums.length == 2){
             return Math.max(nums[0],nums[1]);
         }

         int rob1 = 0;
         int rob2 = 0;

         // rob1 = nums[0];
         // rob2 = Math.max(nums[0],nums[1]);

         for(int j = 0; j<nums.length; j++){

             var temp = Math.max(rob1+nums[j], rob2);
             rob1 = rob2;
             rob2 = temp;
         }

         return rob2;
     }
 }





