/**
 * Created by Robbert on 1/25/15.
 * Factorial Trailing Zeroes
 * https://oj.leetcode.com/problems/factorial-trailing-zeroes/
 */
public class FactorialTrailingZeroes {
    public int trailingZeroesTLE(int n) {
        if (n < 0)  return 0;
        int res = 1;
        for (int i = 1; i <= n; i++) res *= i;
        int count = 0;
        while (res % 10 == 0) {
            count++;
            res /= 10;
        }
        return count;
    }

    public int trailingZeroes(int n) {
        int sum = 0;
        while (n / 5 > 0) {
            sum += n / 5;
            n /= 5;
        }
        return sum;
    }
}
