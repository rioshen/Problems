/**
 * Created by Robbert on 2/1/15.
 * Divide Two Integers
 * https://oj.leetcode.com/problems/divide-two-integers/
 */
public class DivideTwoIntegers {
    /**
     * O(N)
     * Time Limit Exceeded: 2147483647, 1
     * @param dividend
     * @param divisor
     * @return
     */
    public int divideTLE(int dividend, int divisor) {
        if (divisor == 0) {
            return 0;
        }
        int sign = 1;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            sign = -1;
        }
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);

        int n = 0;
        while (a >= b) {
            a -= b;
            n++;
        }
        return sign*n;
    }

    /**
     * O(logN), because each time we multiply by 2
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            return 0;
        }

        boolean negative = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0);
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        int n = 0;
        while (a >= b) {
            int shift = 0;
            while ((b << shift) <= a) {
                shift++;
            }
            System.out.println(shift);
            if (shift >= 32) {
                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            n += 1 << (shift-1);
            a -= b << (shift-1);
        }

        return negative ? -n : n;
    }
}
