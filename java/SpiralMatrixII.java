/**
 * Created by Robbert on 2/1/15.
 * Spiral Matrix II
 * https://oj.leetcode.com/problems/spiral-matrix-ii/
 */
public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        if (n < 0 ) {
            return null;
        }

        int[][] matrix = new int[n][n];
        int num = 1;
        int top = 0, bottom = n - 1, left = 0, right = n - 1;
        while (left < right && top < bottom) {
            for (int i = left; i < right; i++) {
                matrix[top][i] = num++;
            }
            for (int i = top; i < bottom; i++) {
                matrix[i][right] = num++;
            }
            for (int i = right; i > left; i--) {
                matrix[bottom][i] = num++;
            }
            for (int i = bottom; i > top; i--) {
                matrix[i][left] = num++;
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        if (n % 2 != 0) {
            matrix[n / 2][n / 2] = num;
        }
        return matrix;
    }
}
