import java.util.Stack;

/**
 * Created by Robbert on 2/2/15.
 * Longest Valid Parentheses
 * https://oj.leetcode.com/problems/longest-valid-parentheses/
 */
public class LongestValidParentheses {
    /**
     * () - 2
     * )()()( - 4
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) return 0;

        int len = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')' && !stack.isEmpty() && s.charAt(stack.peek()) == '(') {
                stack.pop();
                if (stack.isEmpty()) {
                    len = i + 1;
                } else {
                    len = Math.max(len, i - stack.peek());
                }
            } else {
                stack.push(i);
            }
        }

        return len;
    }
}
