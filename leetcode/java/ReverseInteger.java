/**
 * Created by Robbert on 1/25/15.
 * Reverse Integer
 * https://oj.leetcode.com/problems/reverse-integer/
 */
public class ReverseInteger {
    /**
     * Typical questions about integer: overflow
     * Reverse an integer may cause integer overflow problem.
     * After that, modulor by 10 to get the last significant digit and keep adding
     */
    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            // bug 1: simply compare abs(res) with MAX_VALUE is not enough
            // because there exist one situation that right now, it's smaller
            // than MAX_VALUE, but after this round (multiply by 10) it's already
            // overflow to some wired number.
            if (Math.abs(res) > Integer.MAX_VALUE / 10) return 0;
            res = res * 10 + x % 10;
            x = x / 10;
        }
        return res;
    }
}
