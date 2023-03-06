package math.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * This is a tricky problem, there is an infinite loop case is possible
 */



public class HappyNumber {
    public boolean isHappy(int n) {
        if(n== 0){
            return false;
        }

        Set<Integer> visited = new HashSet<Integer>();
        while(!visited.contains(n)){
            visited.add(n);
            n = sumOfSquares(n);

        }

        if (n == 1){
            return true;
        }else{
            return false;
        }
    }

    private int sumOfSquares(int x){
        int sum = 0;

        while(x > 0){
            var n = x%10;
            x = x/10;
            sum = sum+n*n;
        }
        return sum;
    }
}