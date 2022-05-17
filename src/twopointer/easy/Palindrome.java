package twopointer.easy;

public class Palindrome {

    /**
     * It is a two pointer approach
     * Use Character.isLetterOrDigit()
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {

        if(s == null){
            return false;
        }
        if(s.trim().length() == 0){
            return true;
        }

        String trimStr = trimAlphaNumeric(s);

        int l = 0;
        int r = trimStr.length() -1;

        while(l<r){
            if(trimStr.charAt(l) == trimStr.charAt(r)){
                l++;
                r--;
                continue;
            }else{
                return false;
            }
        }

        return true;
    }


    private String trimAlphaNumeric(String s){


        StringBuilder sb = new StringBuilder();

        for(char c: s.toLowerCase().toCharArray()){


            if ( Character.isLetterOrDigit(c)){
                sb.append(c);
            }
        }

        return sb.toString();

    }
}
