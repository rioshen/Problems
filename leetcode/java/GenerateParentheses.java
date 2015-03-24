import java.util.LinkedList;
import java.util.List;

/**
 * Created by Robbert on 1/26/15.
 * Generate Parentheses
 * https://oj.leetcode.com/problems/generate-parentheses/
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new LinkedList<String>();
        if (n <= 0) {
            return result;
        } else {
            generateHelper(result, "", n, n);
            return result;
        }
    }

    private void generateHelper(List<String> res, String str, int left, int right) {
        if (left > right || left < 0 || right < 0) {
            return;
        }
        if (left == 0 && right == 0) {
            res.add(str);
            return;
        }
        generateHelper(res, str + "(", left - 1, right);
        generateHelper(res, str + ")", left, right - 1);
    }
}
