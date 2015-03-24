import java.util.LinkedList;
import java.util.List;

/**
 * Created by Robbert on 2/7/15.
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
        String path = "";
        generateCombinations(digits, 0, path, res);
        return res;
    }

    private void generateCombinations(String digits, int pos, String path, List<String> res) {
        if (pos == digits.length()) {
            res.add(path);
            return;
        }

        String target = table[digits.charAt(pos) - '0'];
        for (int i = 0; i < target.length(); i++) {
            path += target.charAt(i);
            generateCombinations(digits, pos + 1, path, res);
            path = path.substring(0, path.length() - 1);
        }
    }
}
