/**
 * Created by terry on 1/6/15.
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("N must not be negative number.");
        }

        int a = 1; // n = 0
        int b = 1; // n = 1
        while (n > 1) {
            int temp = a + b;
            a = b;
            b = temp;

            n--;
        }

        return b;
    }
}
