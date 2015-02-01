/**
 * Created by Robbert on 1/31/15.
 * Distinct Subsequences
 * https://oj.leetcode.com/problems/distinct-subsequences/
 */
public class DistinctSubsequences {
    public int numDistinct(String S, String T) {
        if (S == null || T == null) {
            return 0;
        }

        int[][] dp = new int[S.length() + 1][T.length() + 1];
        for (int i = 0; i < S.length(); i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= S.length(); i++) {
            for (int j = 1; j <= T.length(); j++) {
                dp[i][j] = dp[i - 1][j];
                if (S.charAt(i - 1) == T.charAt(j - 1)) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
            }
        }
        return dp[S.length()][T.length()];
    }
}
