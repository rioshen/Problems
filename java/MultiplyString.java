/**
 * Created by Carl Shen on 1/31/15.
 * Multiply Strings
 * https://oj.leetcode.com/problems/multiply-strings/
 */
public class MultiplyString {
    public String multiply(String num1, String num2) {
        int len1 = num1.length(), len2 = num2.length();
        int len = len1 + len2;
        int[] result = new int[len];
        int product = 0, carry = 0, i = 0, j = 0;
        for (i = len1 - 1; i >= 0; i--) {
            carry = 0;
            for (j = len2 - 1; j >= 0; j--) {
                product = carry + result[i + j + 1]
                    + (num2.charAt(j) - '0') * (num1.charAt(i) - '0');
                carry = product / 10;
                result[i + j + 1] = product % 10;
            }
            result[i + j + 1] = carry;
        }

        int start = 0;
        for (; start < len - 1 && result[start] == 0; start++);
        StringBuilder sb = new StringBuilder();
        for (; start < len; start++) sb.append(result[start]);
        return sb.toString();
    }
}
