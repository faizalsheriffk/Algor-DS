package dynamicprogramming.archive;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

    private Map<Integer, Integer> memo = new HashMap<Integer, Integer>();

    public int calculateFib(int n){


        return fibDp(n);
    }


    private int fibDp(int n){
        if(n == 0 || n == 1)
            return n;

        if (!memo.containsKey(n)) {
            memo.put(n, fibDp(n - 1)+fibDp(n-2));
        }
        return memo.get(n);

    }
}
