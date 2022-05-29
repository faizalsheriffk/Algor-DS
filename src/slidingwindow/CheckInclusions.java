package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class CheckInclusions {

    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length())
            return false;
        int[] s1map = new int[26];
        int[] s2map = new int[26];
        int count = 0;

        //fill in
        for(int i = 0; i<s1.length(); i++){
            s1map[s1.charAt(i)-'a']++;
            s2map[s2.charAt(i)-'a']++;
        }

        for(int i =0; i<26; i++){
            if(s1map[i] == s2map[i]){
                count++;
            }
        }


        //implement the sliding window
        int l = 0;
        int index = 0;
        for(int r=s1.length(); r<s2.length(); r++){

            if(count == 26){
                return true;
            }


            index = s2.charAt(r) - 'a';

            s2map[index]++;

            if(s1map[index] == s2map[index]){
                count++;
            }else if(s1map[index] == s2map[index]-1){
                count--;
            }

            index = s2.charAt(l) - 'a';
            s2map[index]--;

            if(s1map[index] == s2map[index]){
                count++;
            }else if(s1map[index] == s2map[index]+1){
                count--;
            }

            l++;
        }

        return count == 26;
    }

    /**
     * The idea is to move left when you are at current right (window end). This will ensure you are not completely
     * draining it
     * @param s1
     * @param s2
     * @return
     */

    public boolean checkInclusionWithMap(String s1, String s2) {

        if (s1.length() > s2.length())
            return false;

        Map<Character, Integer> charCount = new HashMap<Character, Integer>();

        //fill the map

        for(char ch : s1.toCharArray()){
            charCount.put(ch, charCount.getOrDefault(ch, 0)+1);
        }

        char c = ' ';
        int windowStart = 0, matchCnt = 0, value = 0;

        for(int windowEnd = 0; windowEnd < s2.length(); windowEnd++){

            c = s2.charAt(windowEnd);

            if(charCount.containsKey(c)){
                value = charCount.get(c);
                //decrement operator - be careful!! Decrement and assign
                charCount.put(c, --value);
                if(value == 0){
                    matchCnt++;
                }
            }

            if(matchCnt == charCount.size()){
                return true;
            }

            //slide the window from left, this pattern is important
            // increment the left when you are at the current right (window end)

            if(windowEnd >= s1.length()-1){
                c=s2.charAt(windowStart++);

                if(charCount.containsKey(c)){
                    value = charCount.get(c);
                    if(value == 0){
                        matchCnt--;
                    }
                    charCount.put(c, ++value);
                }

            }

        }


        return false;
    }
}
