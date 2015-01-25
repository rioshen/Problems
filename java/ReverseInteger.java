/**
 * Created by Robbert on 1/25/15.
 * Reverse Integer
 * https://oj.leetcode.com/problems/reverse-integer/
 */
public class ReverseInteger {
    public int reverse(int x) {
        int result = 0;

        while (x != 0) {
            if (Math.abs(result) > Integer.MAX_VALUE / 10) {
                return 0;
            } else {
                result = result * 10 + x % 10;
            }
            x /= 10;
        }

        return result;
    }
}
