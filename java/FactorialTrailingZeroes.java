/**
 * Created by Robbert on 1/25/15.
 * Factorial Trailing Zeroes
 * https://oj.leetcode.com/problems/factorial-trailing-zeroes/
 */
public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        int sum = 0;
        while (n / 5 > 0) {
            sum += n / 5;
            n /= 5;
        }
        return sum;
    }
}
