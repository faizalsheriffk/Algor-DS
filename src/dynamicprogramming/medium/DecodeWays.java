package dynamicprogramming.medium;

import java.util.HashMap;
import java.util.Map;

public class DecodeWays {


    private Map<Integer, Integer> memo = new HashMap<Integer, Integer>();

    public int numDecodings(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }

        //return dpByRecursion(s,0);
        //return dpByIterative(s);
        return dpByIterativeConstantSpace(s);
    }

    private int dpByRecursion(String s, int index){

        //The order of these 4 if's is important
        if(memo.containsKey(index)){
            return memo.get(index);
        }

        if(index == s.length()){
            return 1;
        }

        if(s.charAt(index) == '0'){
            return 0;
        }

        if(index == s.length()-1){
            return 1;
        }

        int decodeOneCharPath = dpByRecursion(s, index+1);
        int decodeTwoCharPath = 0;
        //if(index+2<=s.length()){
        var val = Integer.parseInt(s.substring(index, index+2));

        if(val<27){
            decodeTwoCharPath = dpByRecursion(s, index+2);
        }
        //}
        int decodeWays = decodeOneCharPath+decodeTwoCharPath;

        memo.put(index, decodeWays);
        return memo.get(index);
    }


    private int dpByIterative(String s){
        int[] mem = new int[s.length()+1];

        if(s == null || s.length() == 0)
            return 0;


        //base cases
        mem[0] = 1;
        mem[1] = s.charAt(0) == '0'? 0:1;

        //mem[1] = Integer.parseInt(s.substring(0,2)) < 27?2:1;

        for(int i =2; i<mem.length; i++){

            // this is important check
            if(s.charAt(i-1)!='0'){
                mem[i] = mem[i-1];
            }

            int twoDigit = Integer.parseInt(s.substring(i-2,i));

            if(twoDigit>9 && twoDigit <27){
                mem[i] = mem[i]+mem[i-2];
            }
        }

        return mem[s.length()];
    }

    private int dpByIterativeConstantSpace(String s){

        if(s == null && s.length() == 0){
            return 0;
        }

        if(s.charAt(0) == '0'){
            return 0;
        }

        int oneCharBack = 1;
        int twoCharBack = 1;


        for(int i = 1; i<s.length(); i++){
            var current = 0;
            if(s.charAt(i)!='0'){
                current = oneCharBack;
            }

            var twoDigit = Integer.parseInt(s.substring(i-1, i+1));

            if(twoDigit>9 && twoDigit<27){
                current = current+twoCharBack;
            }

            twoCharBack = oneCharBack;
            oneCharBack = current;
        }

        return oneCharBack;
    }
}