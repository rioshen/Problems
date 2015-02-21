public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int start = 0, end = 1;
        int pos = 0, mid = 1;
        while (mid < s.length()) {
            int left = mid - 1;
            int right = mid + 1;
            while (left >= 0 && s.charAt(mid) == s.charAt(left)) {
                left--;
            }
            while (right < s.length() && s.charAt(mid) == s.charAt(right)) {
                right++;
            }
            while (left >= 0 && right < s.length() 
                && s.charAt(left) == s.charAt(right))
            {
                left--;
                right++;
            }
            pos = right - left - 1;
            if (end < pos) {
                start = left + 1;
                end = pos;
            }
            mid++;
        }
        return s.substring(start, start + end);
    }
}