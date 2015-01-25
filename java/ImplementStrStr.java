/**
 * Created by Robbert on 1/25/15.
 * Implement strStr()
 * https://oj.leetcode.com/problems/implement-strstr/
 */
public class ImplementStrStr {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            throw new IllegalArgumentException();
        }

        for (int i = 0;;i++) {
            for (int j = 0;;j++) {
                if (j == needle.length()) {
                    return i;
                }
                if (i + j == haystack.length()) {
                    return -1;
                }
                if (needle.charAt(j) != haystack.charAt(i + j)) {
                    break;
                }
            }
        }
    }
}
