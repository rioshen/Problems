import java.util.Set;

/**
 * Created by Carl Shen on 2/1/15.
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
        if (s == null || s.length() == 0) {
            return true;
        }
        
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && dict.contains(s.substring(j, i)))) {
                    dp[i] = true;
                }
            }
        }
        return dp[s.length() - 1];
    }
}
