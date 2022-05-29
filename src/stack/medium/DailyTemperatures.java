package stack.medium;

import java.util.Stack;

public class DailyTemperatures {

    /**
     * Interesting pattern
     * Monotonic Descending Stack implementation.
     * The key is to hold the indexes of the original array in this
     * stack retaining the descending monotonic property
     * Time Complexity O(N)
     * Space Complexity O(N)
     *
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures(int[] temperatures) {

        if(temperatures.length == 0){
            return new int[0];
        }

        int[] ans = new int[temperatures.length];

        Stack<Integer> stack = new Stack<Integer>();

        for(int i = 0; i<temperatures.length; i++){
            var currentT = temperatures[i];

            // Keep maintaining the monotonic descending property of the stack

            while(!stack.isEmpty() && currentT > temperatures[stack.peek()]){

                var prevDay = stack.pop();
                ans[prevDay] = i - prevDay;
            }
            stack.push(i);
        }

        return ans;
    }

    /**
     * Interesting pattern
     * This utilizes the output space
     * T O(N) and S O(1)
     * @param temperatures
     * @return
     */
    public int[] dailyTemperaturesSuperOptimzed(int[] temperatures) {


        if(temperatures.length == 0){
            return new int[0];
        }

        int[] answer = new int[temperatures.length];

        //variable to keep track of hottest day
        int hottest = 0;

        int days = 1;
        //we are iterating backwards



        for(int i = temperatures.length-1; i>=0; i--){
            /**
             * >= is important as you want to count days equal also as 1
             */
            if(temperatures[i] >= hottest){
                hottest = temperatures[i];
                continue;
            }
            days = 1;

            /**
             * >= is important as you want to count days equal also as 1
             */

            while(temperatures[i]>=temperatures[i+days]){
                days = days+answer[i+days];
            }
            answer[i] = days;
        }
        return answer;
    }

    /**
     * T = O(N2) S = O(N2)
     * @param temperatures
     * @return
     */

    public int[] dailyTemperaturesBruteForce(int[] temperatures) {

          if(temperatures.length == 0){
             return new int[0];
         }


         int[] ans = new int[temperatures.length];


         for(int i = 0; i<temperatures.length; i++){
             for(int j = i+1; j<temperatures.length; j++){
                     if(temperatures[i]<temperatures[j]){
                         ans[i] = j-i;
                         break;
                     }

             }
         }

         return ans;

    }

}
