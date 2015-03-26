/**
 * Created by Carl Shen on 1/25/15.
 * Implement strStr()
 * https://oj.leetcode.com/problems/implement-strstr/
 */
public class ImplementStrStr {
    /**
     * If needle is in haystack, then haystack.length() > needle.length()
     * We're finding needle in haystack, so outer loop must be hasytack and inner must be needle
     * if needle[j] != hasytack[i], break to next round
     */
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        }
        int hLen = haystack.length(), nLen = needle.length();
        if (nLen == 0) {
            return 0;
        } else if (hLen < nLen) {
            return -1;
        }

        for (int i = 0; i < hLen; i++) {
            int n = 0, h = i;
            while (n < nLen && h < hLen && haystack.charAt(h) == needle.charAt(n)) {
                h++;
                n++;
                if (n == nLen) return i;
            }
        }
        return -1;
    }
}
