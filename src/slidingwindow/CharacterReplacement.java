package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class CharacterReplacement {
    /**
     * The natural intuition is to compare the characters but please note,
     * only the length is asked. This is a clue to construct the following formula
     * window length - maxFrequency of a character is less than or equal to k
     * The window length is determined by left and right
     * if the above condition fails then we slide the sliding window by
     * decrementing left, recalculate window length, and use this to calculate
     * answer
     *
     * @param s
     * @param k
     * @return
     */
    public int characterReplacement(String s, int k) {

        if(s == null || s.length() == 0){
            return 0;
        }

        int l=0, ans=0, maxFreq = 0, windowLen=0, count = 0;

        Map<Character,Integer> charCount = new HashMap<Character, Integer>();

        for(int r=0; r<s.length(); r++){

            count = charCount.getOrDefault(s.charAt(r),0)+1 ;

            charCount.put(s.charAt(r), count);
            windowLen = r-l+1;
            maxFreq = Math.max(maxFreq, count);

            if(windowLen-maxFreq > k){
                charCount.put(s.charAt(l), charCount.getOrDefault(s.charAt(l), 1)-1);

                l++;
            }

            windowLen = r-l+1;
            ans = Math.max(ans, windowLen);


        }

        return ans;
    }
}
