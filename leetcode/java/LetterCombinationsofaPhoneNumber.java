import java.util.LinkedList;
import java.util.List;

/**
 * Created by Carl Shen on 2/7/15.
 * Letter Combinations of a Phone Number
 * https://oj.leetcode.com/problems/letter-combinations-of-a-phone-number/
 */
public class LetterCombinationsofaPhoneNumber {
    private final static String[] table = {" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> res = new LinkedList<String>();
        if (digits == null || digits.length() == 0) {
            res.add("");
            return res;
        }
        StringBuilder path = new StringBuilder();
        generateCombinations(digits, 0, path, res);
        return res;
    }

    private void generateCombinations(String digits, int pos, StringBuilder path, List<String> res) {
        if (pos == digits.length()) {
            res.add(path.toString());
        } else {
            String target = table[digits.charAt(pos) - '0'];
            for (int i = 0; i < target.length(); i++) {
                path.append(target.charAt(i));
                generateCombinations(digits, pos + 1, path, res);
                path.setLength(path.length() - 1);
            }
        }
    }
}
