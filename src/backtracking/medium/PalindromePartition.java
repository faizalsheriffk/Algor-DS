package backtracking.medium;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartition {

    private List<List<String>> result = new ArrayList<List<String>>();
    private List<String> currentList = new ArrayList<String>();

    public List<List<String>> partition(String s) {
        dfs(0, s);
        return this.result;
    }

    //aab

    void dfs(int start, String s) {
        //current list is a candidate, clone and add it.
        if (start >= s.length()){
            this.result.add(new ArrayList<String>(this.currentList));
            return;
        }

        for (int end = start; end < s.length(); end++) {
            if (isPalindrome(s, start, end)) {
                // add current substring in the currentList
                this.currentList.add(s.substring(start, end + 1));
                dfs(end + 1, s);
                // backtrack and remove the current substring from currentList
                this.currentList.remove(currentList.size() - 1);
            }
        }
    }

    boolean isPalindrome(String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low++) != s.charAt(high--)) return false;
        }
        return true;
    }
}
