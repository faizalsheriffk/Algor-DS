package backtracking.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Deque;

/**
 * Interesting back tracking
 * Note: Heap based datastructures gets modified at each stage
 * On each exit we have to undo the change that we did on entry
 */
public class generateParenthesis {

    public List<String> generateParenthesis(int n) {
        List<String> combinations = new ArrayList();


        backtrack(combinations, new StringBuffer(), 0, 0, n);

        return combinations;
    }

    public void backtrack(List<String> ans, StringBuffer s, int open, int close, int n) {

        if (open == n && close == n) {

            ans.add(s.toString());
            return;
        }

        if (open < n) {
            s.append("(");
            backtrack(ans, s, open + 1, close, n);
            s.deleteCharAt(s.length() - 1);
        }


        if (close < open) {
            s.append(")");
            backtrack(ans, s, open, close + 1, n);
            s.deleteCharAt(s.length() - 1);
        }
    }
}
