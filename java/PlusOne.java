/**
 * Created by Robbert on 1/25/15.
 * Plus One
 * https://oj.leetcode.com/problems/plus-one/
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return null;
        }

        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = carry + digits[i];
            digits[i] = sum % 10;
            carry = sum / 10;
            // optimize: once we found carry is zero, terminate the program
            if (carry == 0) {
                return digits;
            }
        }

        int[] res = new int[digits.length + 1];
        res[0] = 1;
        for (int i = 1; i < res.length; i++) {
            res[i] = digits[i - 1];
        }
        return res;
    }

}
