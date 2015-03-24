import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Robbert on 2/3/15.
 * Surrounded Regions
 * https://oj.leetcode.com/problems/surrounded-regions/
 */
public class SurroundedRegions {
    /**
     * Flood fill problem
     * 1. first fill all zeroes that connect to the edge into 'Y'
     * 2. After that all zero within the regions replace with 'X'
     * 3. Finally fill all 'Y' back to 0
     */
    public void solveTLE(char[][] board) {
        if (board == null || board.length < 3 || board[0].length < 3)  return;
        fillBoard(board, '0', 'Y');
        replace(board, '0', 'X');
        fillBoard(board, 'Y', '0');
    }

    private void fillBoard(char[][] board, char target, char value) {
        int rows = board.length, cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            if (board[i][0] == target) fill(board, i, 0, target, value);
            if (board[i][cols - 1] == target) fill(board, i, cols - 1, target, value);
        }

        for (int j = 1; j < cols - 1; j++) {
            if (board[0][j] == target) fill(board, 0, j, target, value);
            if (board[rows - 1][j] == target) fill(board, rows - j, j, target, value);
        }
    }

    private void fill(char[][] board, int i, int j, char target, char value) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != target) return;
        board[i][j] = value;
        fill(board, i + 1, j, target, value);
        fill(board, i - 1, j, target, value);
        fill(board, i, j + 1, target, value);
        fill(board, i, j - 1, target, value);
    }

    private void replace(char[][] board, char target, char value) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == target) {
                    board[i][j] = value;
                }
            }
        }
    }

    public void solve(char[][] board) {
        if (board == null || board.length < 3 || board[0].length < 3)  return;

        int rows = board.length;
        int cols = board[0].length;

        // fill top and bottom lines
        for (int j = 0; j < cols; j++) {
            bfs(board, 0, j);
            bfs(board, rows - 1, j);
        }

        // fill left and right lines
        for (int i = 0; i < rows; i++) {
            bfs(board, i, 0);
            bfs(board, i, cols - 1);
        }

        // for all surrounded region fill in X
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == 'Y') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void bfs(char[][] board, int i, int j) {
        int rows = board.length;
        int cols = board[0].length;

        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(i * cols + j);
        while (!queue.isEmpty()) {
            int idx = queue.poll();

            if (idx < 0 || idx >= rows * cols) continue;

            int x = idx / cols;
            int y = idx % cols;
            if (board[x][y] != 'O') continue;

            board[x][y] = 'Y';
            queue.offer(idx + 1);
            queue.offer(idx - 1);
            queue.offer(idx + cols);
            queue.offer(idx - cols);
        }
    }
}
