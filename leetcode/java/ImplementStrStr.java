/**
 * Created by Robbert on 1/25/15.
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
            throw new IllegalArgumentException();
        }
        
        // bug 1: if needle.length is zero return 0;
        if (haystack.length() >= needle.length() && needle.length() == 0) return 0;
        if (haystack.length() < needle.length()) return -1;
        
        for (int i = 0; i < haystack.length(); i++) {
            for (int j = 0; j < needle.length(); j++) {
                if (i + j >= haystack.length()) return -1;
                if (haystack.charAt(i + j) != needle.charAt(j)) break;
                if (j == needle.length() - 1) return i;
            }
        }
        return -1;
    }
}
