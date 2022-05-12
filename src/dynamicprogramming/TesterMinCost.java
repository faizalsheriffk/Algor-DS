package dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;

public class TesterMinCost {

    public static void main(String[] args){
        MinCostClimbingStars minCostClimbingStars = new MinCostClimbingStars();
        int[] stairsCost = {2,3,12,78,1};
        System.out.println(Arrays.binarySearch(stairsCost,1));
        System.out.println(""+minCostClimbingStars.minCostClimbingStairs(stairsCost));
        //reverse(123);
        myAtoi("-91283472332");
    }

    public static int reverse(int x) {
        if (x >=0 && x <10)
            return x;

        try{
            int reverse = 0;
            int carry = 0;
            int tenP = 0;
            int xy = Integer.MIN_VALUE;
            while(x > 0){
                carry = x%10;
                reverse = reverse+(carry*(int)Math.pow(10,tenP));

                tenP++;

                x = x/10;
                char c = '1';
                int l = c;
                long lon = -91283472332L;
                if( lon <= Integer.MIN_VALUE){
                    System.out.println("true");
                }

            }
            return reverse;

        }catch(Exception e){
            return 0;

        }
    }

    public static int myAtoi(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }

        int sign = 1;
        int signedInt = 0;
        char c = ' ';
        long calcVal = 0L;


        for(int i = 0; i<s.length(); i++){
            c = s.charAt(i);
            if( c == ' ')
                continue;
            else if(c =='-')
                sign = -1;
            else if((c >=65 && c<=90) || (c>=97 && c<=122)){

                if(signedInt == 0){
                    return signedInt;
                }
            }


            else if(c>=48 && c<=57){
                calcVal = stringToInt(signedInt, c);
                if(sign >0 && calcVal>= Integer.MAX_VALUE)
                    return Integer.MAX_VALUE;
                else if(sign < 0 && (calcVal*sign <= -Integer.MIN_VALUE))
                    return Integer.MIN_VALUE;
                else
                    signedInt = (int)stringToInt(signedInt, c);
            }



        }
        return signedInt*sign;

    }


    private static long stringToInt(Integer s, char c){

        long x = (long)s*10+Integer.parseInt(String.valueOf(c));
        return x;

    }
}
