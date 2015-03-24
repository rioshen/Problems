/**
 * Created by Robbert on 1/25/15.
 * Length of Last Word
 * https://oj.leetcode.com/problems/length-of-last-word/
 */
public class LengthofLastWord {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int end = s.length() - 1;
        while (end >= 0 && s.charAt(end) == ' ') {
            end--;
        }
        if (end < 0) {
            return 0;
        }

        int length = 0;
        for (int i = end; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                break;
            } else {
                length++;
            }
        }
        return length;
    }
    
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) return 0;
        s = s.trim();
        if (s.length() == 0) return 0;
        String[] words = s.split(" ");
        return words[words.length - 1].length();
    }
}
