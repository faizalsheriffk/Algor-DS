package dynamicprogramming;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Tribonacci {

    private Map<Integer, Integer> memo = new HashMap<Integer, Integer>();

    public int tribonacci(int n) {


        return calcTribonacci(n);
    }

    private int calcTribonacci(int n){

        if(n <= 0){
            memo.put(0, 0);
            return 0;
        }
        else if( n == 1 || n == 2){
            memo.put(n, 1); // put if does not contain
            return 1;
        }

        if(!memo.containsKey(n)){
            memo.put(n,  calcTribonacci(n-1)+calcTribonacci(n-2)+calcTribonacci(n-3));
        }

        return memo.get(n);

    }

}
