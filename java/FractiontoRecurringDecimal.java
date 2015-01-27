/**
 * Created by Robbert on 1/26/15.
 * Fraction to Recurring Decimal
 * https://oj.leetcode.com/problems/fraction-to-recurring-decimal/
 */
public class FractiontoRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        if (denominator == 0) {
            return "";
        }

        String answer = "";
        if (numerator * denominator < 0) {
            answer += "-";
        }


    }
}
