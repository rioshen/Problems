import java.util.LinkedList;
import java.util.List;

/**
 * Created by Robbert on 2/1/15.
 * Spiral Matrix
 * https://oj.leetcode.com/problems/spiral-matrix/
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new LinkedList<Integer>();
        if (matrix == null || matrix.length == 0) {
            return res;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int pos = 0;
        while (pos * 2 < rows && pos * 2 < cols) {
            for (int i = pos; i < cols - pos; i++) {
                res.add(matrix[pos][i]);
            }
            for (int i = pos + 1; i < rows - pos; i++) {
                res.add(matrix[i][cols - pos - 1]);
            }

            if (rows - 2 * pos == 1 || cols - 2 * pos == 1) {
                break;
            }

            for (int i = cols - pos - 2; i >= pos; i--) {
                res.add(matrix[rows - pos - 1][i]);
            }
            for (int i = rows - pos - 2; i >= pos + 1; i--) {
                res.add(matrix[i][pos]);
            }

            pos++;
        }

        return res;
    }
}
