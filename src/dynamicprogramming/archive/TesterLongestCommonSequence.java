package dynamicprogramming.archive;

public class TesterLongestCommonSequence {

    public static void main(String[] args){
        LongestCommonSubsequence longestCommonSubsequence = new LongestCommonSubsequence();
        String test1 = "abcde";
        String test2 = "ace";
        System.out.println(longestCommonSubsequence.longestCommonSubsequence(test1, test2));
    }
}
