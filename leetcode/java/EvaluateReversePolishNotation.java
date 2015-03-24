import java.util.Stack;

/**
 * Created by Robbert on 1/30/15.
 * Evaluate Reverse Polish Notation
 * https://oj.leetcode.com/problems/evaluate-reverse-polish-notation/
 */
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            throw new IllegalArgumentException();
        }

        String operators = "+-*/";
        Stack<Integer> stack = new Stack<Integer>();
        for (String token : tokens) {
            if (!operators.contains(token)) {
                stack.push(Integer.valueOf(token));
            } else {
                if (stack.isEmpty()) {
                    throw new IllegalArgumentException();
                }
                int a = stack.pop();
                int b = stack.pop();
                if (token.equals("+")) {
                    stack.push(a + b);
                } else if (token.equals("-")) {
                    stack.push(b - a);
                } else if (token.equals("*")) {
                    stack.push(b * b);
                } else {
                    stack.push(b / a);
                }
            }
        }

        return stack.pop();
    }
}
