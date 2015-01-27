import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Robbert on 1/27/15.
 * Largest Number
 * https://oj.leetcode.com/problems/largest-number/
 */
public class LargestNumber {
    public String largestNumber(int[] num) {
        if (num == null || num.length == 0) {
            return "0";
        }

        String[] content = new String[num.length];
        for (int i = 0; i < content.length; i++) {
            content[i] = String.valueOf(num[i]);
        }

        Arrays.sort(content, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                double t1 = Double.valueOf(a + b);
                double t2 = Double.valueOf(b + a);
                if (t1 > t2) {
                    return -1;
                } else if (t1 < t2) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        if (content[0].equals("0")) {
            return "0";
        }

        StringBuilder result = new StringBuilder();
        for (String elem : content) {
            result.append(elem);
        }
        return result.toString();
    }
}
