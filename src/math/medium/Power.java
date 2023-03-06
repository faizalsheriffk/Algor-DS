package math.medium;

public class Power {

    class Solution {
        // public double myPow(double x, int n) {
        //     // Linear path exceeds time
        //     // if(x == 1.0 || x == 0.0){
        //     //     return x;
        //     // }
        //     // double result = 1.0;

        //     // int counter = Math.abs(n)/2;

        //     // while(counter>0){
        //     //     result = result*x;
        //     //     counter--;
        //     // }
        //     // result = Math.abs(n)%2 == 0? result*result : result*result*x;


        //     // the below solution has Integer Max Min value boundary issues
        //     double result = 0.0;
        //     result = powUtil(x,Math.abs(n));

        //     if (n>0){
        //      return result;
        //     }
        //     else{
        //     result = 1/result;
        //     return result;
        //     }
        // }

        // private double powUtil(double x, int n){
        //     if(n == 0){
        //         return 1;
        //     }
        //     if(x == 0.0 || x == 1.0){
        //         return x;
        //     }

        //     double result = powUtil(x, n/2);
        //     result = result * result;

        //     if(n%2 > 0){
        //         return result * x;
        //     }else{
        //         return result;
        //     }

        // }

//BASICALLY YOU CANNOT SIMPLIFY - minus value as straight forward and return the final value as 1/calculated result. It caused issues around Integer. MINVALUE AND MAXVALUE.

//Instead of using the classic recursive approach i.e. x*pow(x, n-1) just have (x*x), i.e., pow(x*x, n/2).
//This will make the TC logarithmic instead of linear.
//Just take care of the edge cases like Integer.MIN_VALUE, negative power, odd cases.
//Asked in Amazon, Meta, Google, Linkedin, Bloomberg


        public double myPow(double x, int n) {
            if (n == 0) {
                return 1;
            }
            //Make the negative values positive
            else if (n < 0) {
                //whenever even just divide it by 2
                //this will also include Integer.MIN_VALUE
                //We're doing this because if I do -N and N=Integer.MIN_VALUE it'll become a value which is greater than the max value of Integer.MAX_VALUE
                if (n % 2 == 0) {
                    n = n / 2;
                    n = -n;
                    x = (1 / x) * (1 / x);
                } else { //Odds don't need to be divided as their negative is in the positive limit
                    n = -n;
                    x = 1 / x;
                }
            }
            if (n % 2 == 0) { //even
                return myPow(x * x, n / 2);
            } else { //odd
                return x * myPow(x * x, n / 2);
            }
        }

    }
}
