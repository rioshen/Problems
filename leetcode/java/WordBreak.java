import java.util.Set;

/**
 * Created by Robbert on 2/1/15.
 * Word Break
 * https://oj.leetcode.com/problems/word-break/
 */
public class WordBreak {
    /**
     * TLE: Backtracking, generate all possible results and see whether contains
     * @param s
     * @param dict
     * @return
     */
    public boolean wordBreak(String s, Set<String> dict) {
        if (s == null || dict == null) {
            return false;
        } else {
            return wordBreakHelper(s, dict, 0);
        }
    }

    private boolean wordBreakHelper(String s, Set<String> dict, int pos) {
        if (pos == s.length()) {
            return true;
        }
        for (String elem : dict) {
            int len = elem.length();
            int end = pos + len;
            if (end > s.length()) {
                continue;
            }
            if (s.substring(pos, end).equals(elem)) {
                if (wordBreakHelper(s, dict, end)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean wordBreakII(String s, Set<String> dict) {
        if (s == null || dict == null) {
            return false;
        }
        if (dict.contains(s)) {
            return true;
        }

        boolean[] table = new boolean[s.length() + 1];
        table[0] = true;
        for (int i = 0; i < s.length(); i++) {
            if (!table[i]) {
                continue;
            }
            for (String seg : dict) {
                int end = i + seg.length();
                if (end > s.length() || table[end]) {
                    continue;
                }
                if (s.substring(i, end).equals(seg)) {
                    table[end] = true;
                }
            }
        }

        return table[s.length()];
    }
}
