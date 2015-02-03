import java.util.LinkedList;
import java.util.List;

/**
 * Created by Robbert on 2/2/15.
 * N-Queens II
 * https://oj.leetcode.com/problems/n-queens-ii/
 */
public class NQueensII {
    public int totalNQueens(int n) {
        if (n <= 0) {
            return 0;
        } else {
            return solve(n, 0, new LinkedList<Integer>());
        }
    }

    private int solve(int n, int rows, List<Integer> path) {
        if (rows == n) {
            return 1;
        }

        int num = 0;
        for (int i = 0; i < n; i++) {
            if (!isValid(i, path)) {
                continue;
            }
            path.add(i);
            num += solve(n, rows + 1, path);
            path.remove(path.size() - 1);
        }

        return num;
    }

    private boolean isValid(int cols, List<Integer> path) {
        int rows = path.size();
        for (int i = 0; i < rows; i++) {
            if (cols == path.get(i)) {
                return false;
            }
            if (rows - i == Math.abs(cols - path.get(i))) {
                return false;
            }
        }
        return true;
    }
}
