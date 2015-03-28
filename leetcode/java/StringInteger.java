/**
 * Created by Carl Shen on 1/6/15.
 * String to Integer (atoi)
 * https://oj.leetcode.com/problems/string-to-integer-atoi/
 */
public class StringInteger {
    /**
     * Take care of the leading sign both flag var and position var.
     *
     * Take care of the integer overflow, the best way to prevent Integer overflow
     * is to do a precondition testing, if we want to multiply left by right, test
     * left > Integer.MAX_VALUE / right first. In this problem right = 10.
     * based on the requirement, return
     * the MIN or MAX directly.
     */
    public int atoi(String str) {
        if (str == null || str.length() == 0) return 0;
        str = str.trim();
        if (str.length() == 0) return 0;

        boolean negative = str.charAt(0) == '-';
        // bug 1: don't forget + sign
        int pos = str.charAt(0) == '-' || str.charAt(0) == '+' ? 1 : 0;
        // I think below is a good way to filter multiple +/-
        //while (pos < str.length() && (str.charAt(pos) == '+' || str.charAt(pos) == '-')) pos++;

        double res = 0.0;
        while (pos < str.length()) {
            char c = str.charAt(pos);
            if (!Character.isDigit(c)) {
                break;
            }

            // Modificatoin of bug 1
            // before really multiply, test precondition multiply first
            // https://www.securecoding.cert.org/confluence/display/java/NUM00-J.+Detect+or+prevent+integer+overflow
            if (res >= Integer.MAX_VALUE / 10 || res == Integer.MAX_VALUE / 10 && c >= '8') {
                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            res = res * 10 + c - '0';
            pos++;
        }

        // bug 1 -2147483647 -> -2147483648: can't protect integer overflow
        // if (res >= Integer.MAX_VALUE) return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        return negative ? -(int)res : (int)res;
    }

    public int atoiRefactor(String str) {
        if (str == null) {
            return 0;
        }

        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }

        int res = 0, pos = 0, sign = str.charAt(0) == '-' ? -1 : 1;
        if (str.charAt(pos) == '-' || str.charAt(pos) == '+') {
            pos++;
        }
        for (; pos < str.length() && Character.isDigit(str.charAt(pos)); pos++) {
            int digit = str.charAt(pos) - '0';
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && digit >= 8)) {
                return (sign == -1) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            res = res * 10 + digit;
        }
        return sign * res;
    }
}
