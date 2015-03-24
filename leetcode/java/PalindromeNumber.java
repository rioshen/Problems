/**
 * Created by Robbert on 1/25/15.
 * Palindrome Number
 * https://oj.leetcode.com/problems/palindrome-number/
 */
public class PalindromeNumber {
    /**
     * negative number couldn't be palindrome.
     * To avoid Integer Overflow, a good way is to calculate the length of input number
     * For array, we do this by using the length member, for a number we can calculate 
     * a divisor that can make it become a digit (< 10).
     * After this, compare left and right pair.
     */
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int div = 1;
        while (x / div >= 10) div *= 10;
        while (x != 0) {
            int left = x / div;
            // bug 1: module by div is wrong, should be 10
            int right = x % 10;
            if (left != right) return false;
            // mod by div, remove the left, divide by 10 remove the right
            x = (x % div) / 10; 
            div /= 100; // move two steps.
        }
        return true;
    }
}
