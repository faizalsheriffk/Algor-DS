package slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;

public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstringUsingSet(String s){

        if(s.length() == 0){
            return 0;
        }
        HashSet<Character> set = new LinkedHashSet<Character>();

        int l = 0, r = 0, max=0;

        while (r<s.length()){

            if(!set.contains(s.charAt(l))){
                r++;
            }else{
                set.remove(s.charAt(l));
                l++;
            }
            max = Math.max(max, r-l+1);
        }
        return max;
    }

    public int lengthOfLongestSubstring(String s) {

        if(s.length() == 0){
            return 0;
        }

        Map<Character,Integer> map = new HashMap<Character,Integer>();
        char c = ' ';
        int maxLen = 0;
        for(int l=0, r= 0; r< s.length(); r++){

            c = s.charAt(r);

            if(map.containsKey(c)){
                /**
                 * This check is more important because your l
                 * might have moved inwards due to other character
                 * for example abba
                 */

                if(map.get(c) >= l){
                    l = map.get(c)+1;
                }
            }

            maxLen = Math.max(maxLen, r-l+1);
            map.put(c, r);

        }
        return maxLen;
    }

}
