/**
 * Created by Robbert on 1/25/15.
 * Longest Common Prefix
 * https://oj.leetcode.com/problems/longest-common-prefix/
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            while (j < prefix.length()
                    && j < strs[i].length()
                    && strs[i].charAt(j) == prefix.charAt(j))
            {
                j++;
            }
            if (j == 0) {
                return "";
            } else {
                prefix = prefix.substring(0, j);
            }
        }

        return prefix;
    }
}
