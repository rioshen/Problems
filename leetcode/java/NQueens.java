import java.util.LinkedList;
import java.util.List;

/**
 * Created by Robbert on 2/2/15.
 * N-Queens
 * https://oj.leetcode.com/problems/n-queens/
 */
public class NQueens {
    public List<String[]> solveNQueens(int n) {
        List<String[]> result = new LinkedList<String[]>();
        if (n <= 0) return result;
        solve(n, new LinkedList<Integer>(), result);
        return result;
    }

    public void solve(int n, List<Integer> sol, List<String[]> res) {
        if (sol.size() == n) {
            res.add(draw(sol));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!isValid(sol, i)) {
                continue;
            }
            sol.add(i);
            solve(n, sol, res);
            sol.remove(sol.size() - 1);
        }
    }

    private String[] draw(List<Integer> cols) {
        String[] chessboard = new String[cols.size()];
        for (int i = 0; i < cols.size(); i++) {
            chessboard[i] = "";
            for (int j = 0; j < cols.size(); j++) {
                if (j == cols.get(i)) {
                    chessboard[i] += "Q";
                } else {
                    chessboard[i] += ".";
                }
            }
        }

        return chessboard;
    }

    private boolean isValid(List<Integer> cols, int col) {
        int row = cols.size();
        for (int i = 0; i < row; i++) {
            // same column
            if (cols.get(i) == col)  {
                return false;
            }
            // left-top to right-bottom
            if (i - cols.get(i) == row - col) {
                return false;
            }
            // right-top to left-bottom
            if (i + cols.get(i) == row + col) {
                return false;
            }
        }
        return true;
    }
}
