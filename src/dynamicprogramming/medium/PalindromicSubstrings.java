package dynamicprogramming.medium;

public class PalindromicSubstrings {

    public int countSubstrings(String s) {

        if(s == null || s.length() == 0){
            return 0;
        }

        int count = 0;

        for(int i = 0; i< s.length(); i++){

            count += expandAroundCenter(i,i, s);
            //The key to understand here is that there is no overlap here.
            count += expandAroundCenter(i, i+1,s);

        }

        return count;
    }


    private int expandAroundCenter(int s, int e, String str){
        int count = 0;
        while(s>-1 && e<str.length() && str.charAt(s) == str.charAt(e)){

            s--;
            e++;
            count++;
        }

        return count;
    }
}
