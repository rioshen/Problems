/**
 * Created by Robbert on 1/30/15.
 * Reverse Words in a String
 * https://oj.leetcode.com/problems/reverse-words-in-a-string/
 */
public class ReverseWordsinaString {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        String[] content = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = content.length - 1; i >= 0; i--) {
            if (!content[i].equals("")) {
                sb.append(content[i]).append(" ");
            }
        }

        return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1);
    }
}
