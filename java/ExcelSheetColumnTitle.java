/**
 * Created by Robbert on 1/23/15.
 * Excel Sheet Column Title
 * https://oj.leetcode.com/problems/excel-sheet-column-title/
 *
 * Solution
 * Mod operation, (number - 1) % 26 + 'A'
 * (number - 1) / 26
 */
public class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        if (n < 0) {
            return "";
        }

        String result = "";
        while (n > 0) {
            int title = (n - 1) % 26 + (int)'A';
            result = (char)title + result;
            n = (n - 1) / 26;
        }

        return result;
    }
}