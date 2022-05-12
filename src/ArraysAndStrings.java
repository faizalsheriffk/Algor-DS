import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class ArraysAndStrings {

    public static void main(String args[]) {
        System.out.println("Welcome to arrays and strings");
        ArraysAndStrings a = new ArraysAndStrings();
//        System.out.println(a.lengthOfLongestSubstring("abcabcbb"));
//        System.out.println(a.lengthOfLongestSubstring("bbbbbbb"));
//        System.out.println(a.lengthOfLongestSubstring("pwwkew"));
//        System.out.println(a.lengthOfLongestSubstring(" "));
//        System.out.println(a.lengthOfLongestSubstring("a"));
//        System.out.println(a.lengthOfLongestSubstring(" a"));
//        System.out.println(a.lengthOfLongestSubstring("ABDEFGABEF"));
//        System.out.println(a.lengthOfLongestSubstringAlternate("abcabcbb"));
//        System.out.println(a.lengthOfLongestSubstringAlternate("bbbbbbb"));
//        System.out.println(a.lengthOfLongestSubstringAlternate("pwwkew"));
//        System.out.println(a.lengthOfLongestSubstringAlternate(" "));
//        System.out.println(a.lengthOfLongestSubstringAlternate("a"));
//        System.out.println(a.lengthOfLongestSubstringAlternate(" a"));
//        System.out.println(a.lengthOfLongestSubstringAlternate("ABDEFGABEF"));
//        System.out.println(a.lengthOfLongestSubstringAlternate2("abcabcbb"));
//        System.out.println(a.lengthOfLongestSubstringAlternate2("bbbbbbb"));
//        System.out.println(a.lengthOfLongestSubstringAlternate2("pwwkew"));
//        System.out.println(a.lengthOfLongestSubstringAlternate2(" "));
//        System.out.println(a.lengthOfLongestSubstringAlternate2("a"));
        System.out.println(a.lengthOfLongestSubstringAlternate2("abba"));
        //System.out.println(a.lengthOfLongestSubstringAlternate2("ABDEFGABEF"));



    }


    //faster solution in terms of time and space. It is 93.33% faster and 88.9% memory efficient
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        final int MAX_LENGTH = 128;
        int[] lastVisitedIndexOfChar = new int[MAX_LENGTH];

        //initialize the value to - 1
        Arrays.fill(lastVisitedIndexOfChar, -1);

        int curSlidingWindowStartIndex = 0;
        int curSlidingWindowLength = 0;

        for (int cureSlidingWindowEndIndex = 0; cureSlidingWindowEndIndex < s.length(); cureSlidingWindowEndIndex++) {
            //move the startIndex to new index if there is a character that is already visited i.e slide
            curSlidingWindowStartIndex = Math.max(curSlidingWindowStartIndex, lastVisitedIndexOfChar[s.charAt(cureSlidingWindowEndIndex)] + 1);

            //increment the length of the current sliding window as long as it is  longer
            curSlidingWindowLength = Math.max(curSlidingWindowLength, cureSlidingWindowEndIndex - curSlidingWindowStartIndex + 1);

            //update the index of the last visited character
            lastVisitedIndexOfChar[s.charAt(cureSlidingWindowEndIndex)] = cureSlidingWindowEndIndex;


        }

        return curSlidingWindowLength;

    }


    // Relatively readable code but a slight compromise in speed and memory utiization
    // faster solution stats in terms of time and space. It is 67.33% faster and 76.9% memory efficient
    public int lengthOfLongestSubstringAlternate(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }


        Map<String, Integer> lastVisitedIndexOfChar = new HashMap<String, Integer>();

        int curSlidingWindowStartIndex = 0;
        int curSlidingWindowLength = 0;
        String key = "";

        for (int cureSlidingWindowEndIndex = 0; cureSlidingWindowEndIndex < s.length(); cureSlidingWindowEndIndex++) {
            //move the startIndex to new index if there is a character that is already visited i.e slide
            key = String.valueOf(s.charAt(cureSlidingWindowEndIndex));
            curSlidingWindowStartIndex = Math.max(curSlidingWindowStartIndex, (lastVisitedIndexOfChar.get(key) == null ? -1 : lastVisitedIndexOfChar.get(key) + 1));

            //increment the length of the current sliding window as long as it is  longer
            curSlidingWindowLength = Math.max(curSlidingWindowLength, cureSlidingWindowEndIndex - curSlidingWindowStartIndex + 1);

            //update the index of the last visited character
            lastVisitedIndexOfChar.put(String.valueOf(s.charAt(cureSlidingWindowEndIndex)), cureSlidingWindowEndIndex);

        }

        return curSlidingWindowLength;
    }


    public int lengthOfLongestSubstringAlternate2(String s) {
        //ABDEFGABEF

        //sanity check
        if (s == null || s.length() == 0) {
            return 0;
        }

        //sliding window construction
        int[] array = new int[128];
        Arrays.fill(array, -1);

        int slidingWindowStart = 0;
        int slidingWindowLength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (array[s.charAt(i)] != -1) {
                slidingWindowStart = Math.max(slidingWindowStart, array[s.charAt(i)] + 1);

            }
            slidingWindowLength = Math.max(slidingWindowLength, i - slidingWindowStart + 1);
            array[s.charAt(i)] = i;

        }
        return slidingWindowLength;
    }

}
