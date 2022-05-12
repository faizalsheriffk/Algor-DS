package hsshmap;

import com.sun.tools.javac.Main;

import java.nio.charset.CharsetEncoder;
import java.util.HashMap;

import java.util.HashMap;

public class MainTester {

    public static void main(String[] args){

        System.out.println("Hello "+new MainTester().firstRepeatedChar("How wo are you walter")+" you there");


    }

// how are you walter
    public Character firstRepeatedChar(String s){

        HashMap<Character, Character> uniqueMap = new HashMap<Character, Character>();
        for (Character c: s.toCharArray()){
            if(uniqueMap.containsKey(c)){
                return c;
            }
            uniqueMap.put(c,c);
        }
        return null;
    }
}
