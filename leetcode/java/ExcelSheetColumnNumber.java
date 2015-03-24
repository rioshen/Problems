/**
 * Created by Robbert on 1/23/15.
 * Excel Sheet Column Number
 * https://oj.leetcode.com/problems/excel-sheet-column-number/
 *
 * Mapping Relation: ch - 'A' + 1
 */
public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int result = 0;
        for (char element : s.toCharArray()) {
            result = result * 26 + element - 'A' + 1;
        }

        return result;
    }
}
