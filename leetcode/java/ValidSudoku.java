import java.util.HashSet;
import java.util.Set;

/**
 * Created by Robbert on 1/25/15.
 * Valid Sudoku
 * https://oj.leetcode.com/problems/valid-sudoku/
 */
public class ValidSudoku {
    private static final int ROWLENGTH = 9;
    private static final int COLLENGTH = 9;
    private static final int SUBMATRIX = 9;

    public boolean isValidSudoku(char[][] board) {

        for (int c = 0; c < board[0].length; c++) {
            Set<Character> visited = new HashSet<Character>();
            for (int r = 0; r < board.length; r++) {
                if (board[r][c] != '.' && !visited.add(board[r][c])) {
                    return false;
                }
            }
        }

        for (int r = 0; r < board.length; r++) {
            Set<Character> visited = new HashSet<Character>();
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] != '.' && !visited.add(board[r][c])) {
                    return false;
                }
            }
        }

        for (int i = 0; i < SUBMATRIX; i += 3) {
            for (int j = 0; j < SUBMATRIX; j += 3) {
                Set<Character> visited = new HashSet<Character>();
                for (int k = 0; k < SUBMATRIX; k++) {
                    if (board[i + k/3][ j + k%3] != '.' && !visited.add(board[i + k/3][ j + k%3])) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
