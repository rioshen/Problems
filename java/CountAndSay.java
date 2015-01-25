/**
 * Created by Robbert on 1/25/15.
 * Count and Say
 * https://oj.leetcode.com/problems/count-and-say/
 */
public class CountAndSay {
    public String countAndSay(int n) {
        String current = "1";
        while (n > 1) {
            StringBuilder sb = new StringBuilder();
            char[] content = current.toCharArray();
            for (int i = 0; i < content.length; i++) {
                int count = 1;
                while ((i + 1) < content.length && content[i] == content[i + 1]) {
                    count++;
                    i++;
                }
                sb.append(String.valueOf(count) + String.valueOf(content[i]));
            }
            current = sb.toString();
            n--;
        }

        return current;
    }

}
