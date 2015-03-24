/**
 * Created by Robbert on 1/25/15.
 * Count and Say
 * https://oj.leetcode.com/problems/count-and-say/
 */
public class CountAndSay {
    /**
     * 1211 -> 111221 -> 312211 -> 13112221
     * Here we're basically doing a encoding and decoding like run length compression
     * Base String is "1" and counter should also be 1
     * first time in the loop, we push str + counter to buffer
     * Next time (we have 11), i starts at 1, if i == i - 1, counter++.
     */
    public String countAndSay(int n) {
        if (n <= 0) return "";
        String prefix = "1";
        while (n > 1) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < prefix.length(); i++) {
                int counter = 1;
                while (i + 1 < prefix.length() && prefix.charAt(i) == prefix.charAt(i + 1)) {
                    counter++;
                    i++;
                }
                sb.append(counter).append(prefix.charAt(i));
            }
            prefix = sb.toString();
            n--;
        }
        return prefix;
    }
}
