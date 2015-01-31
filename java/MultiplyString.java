/**
 * Created by Robbert on 1/31/15.
 * Multiply Strings
 * https://oj.leetcode.com/problems/multiply-strings/
 */
public class MultiplyString {
    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null) {
            throw new IllegalArgumentException();
        }

        int len1 = num1.length();
        int len2 = num2.length();
        int maxlen = len1 + len2;

        int[] result = new int[maxlen];
        int carry, i, j;
        for (i = len1 - 1; i >= 0; i--) {
            carry = 0;
            for (j = len2 - 1; j >= 0; j--) {
                int product = carry
                        + result[i + j + 1]
                        + Character.getNumericValue(num1.charAt(i))
                        * Character.getNumericValue(num2.charAt(j));
                carry = product / 10;
                result[i + j + 1] = product % 10;
            }
            result[i + j + 1] = carry;
        }

        int index = 0;
        while (index <= maxlen && result[index] == 0) {
            index++;
        }
        StringBuilder sb = new StringBuilder();
        while (index < maxlen) {
            sb.append(result[index]);
            index++;
        }
        return sb.toString();
    }
}
