/**
 * Created by Robbert on 1/30/15.
 * Maximum Product Subarray
 * https://oj.leetcode.com/problems/maximum-product-subarray/
 */
public class MaximumProductSubarray {
    public int maxProduct(int[] A) {
        if (A == null || A.length == 0) {
            throw new IllegalArgumentException();
        }

        int[] dp = new int[A.length];
        int positive = Math.max(A[0], 0);
        int negative = Math.min(A[0], 0);
        for (int i = 1; i < A.length; i++) {
            int element = A[i];
            if (element == 0) {
                positive = 0;
                negative = 0;
            } else if (element > 0) {
                positive = Math.max(positive, positive * element);
                negative *= element;
            } else {
                int temp = positive;
                positive = negative * element;
                negative = Math.min(element, temp * negative);
            }
            dp[i] = Math.max(dp[i - 1], positive);
        }

        return dp[A.length - 1];
    }

    /**
     * Relationship between dp is just i and i - 1, a local variable is enough.
     * @param A
     * @return
     */
    public int maxProductInplace(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        int result = A[0];
        int positive = Math.max(0, A[0]);
        int negative = Math.min(0, A[0]);
        for (int i = 1; i < A.length; i++) {
            int element = A[i];
            if (element > 0) {
                positive = Math.max(element, positive * element);
                negative *= element;
            } else if (element < 0) {
                int temp = positive;
                positive = negative * element;
                negative = Math.min(temp * element, element);
            }
            result = Math.max(positive, result);
        }

        return result;
    }
}
