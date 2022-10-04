package dynamicprogramming.medium;

public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {

        if(s == null || s.length() == 0){
            return "";
        }

        int oddLength = 0;
        int evenLength = 0;

        int startIndex = 0;
        int endIndex = 0;
        int length = 0;
        //expanding around the center
        for(int i = 0; i < s.length(); i++){
            //calculate the length starting at odd index, like start with self, self character
            oddLength = expandAroundCenter(i,i,s);

            //calculate the length starting at even index, like start with self and character next to it
            evenLength = expandAroundCenter(i, i+1,s);
            length = Math.max(oddLength, evenLength);
            if((endIndex-startIndex) < length){
                //compute new start, end index
                startIndex = i-((length-1)/2);
                endIndex = i+(length/2);

            }

        }

        return s.substring(startIndex, endIndex+1);

    }


    private int expandAroundCenter(int startIndex, int endIndex, String s){

        int l = startIndex;
        int r = endIndex;

        while(l>=0 && r<s.length() && s.charAt(l) == s.charAt(r)){
            l--;
            r++;
        }

        return r-l-1;

    }
}
