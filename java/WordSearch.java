/**
 * Word Search
 * https://oj.leetcode.com/problems/word-search/
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) {
            return false;
        }
        if (word == null || word.length() == 0) {
            return true;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (find(board, word, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean find(char[][] board, String word, int i, int j, int pos) {
        if (pos == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length
                || j < 0 || j >= board[0].length
                || board[i][j] != word.charAt(pos)) {
            return false;
        }

        board[i][j] = '#';
        boolean result = find(board, word, i + 1, j, pos + 1)
                || find(board, word, i - 1, j, pos + 1)
                || find(board, word, i, j + 1, pos + 1)
                || find(board, word, i, j - 1, pos + 1);
        board[i][j] = word.charAt(pos);

        return result;
    }
}
