/**
 * Created by Robbert on 1/26/15.
 * Fraction to Recurring Decimal
 * https://oj.leetcode.com/problems/fraction-to-recurring-decimal/
 */
public class FractiontoRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        if (denominator == 0) {
            return "";
        }
        String result = String.valueOf((double)numerator / denominator);
        System.out.println(result);
        StringBuilder content = new StringBuilder();
        boolean foundDups = false;
        char prev = '0';
        for (int i = 0; i < result.length() - 1; i++) {
            char curr = result.charAt(i);
            if (curr == result.charAt(i + 1)) {
                foundDups = true;
                prev = curr;
                continue;
            }
            if (foundDups) {
                content.append("(").append(curr).append(")");
                foundDups = false;
            } else {
                content.append(curr);
            }
        }
        if (foundDups) {
            content.append("(").append(prev).append(")");
        }

        return content.toString();
    }

    public static void main(String[] args) {
        FractiontoRecurringDecimal sol = new FractiontoRecurringDecimal();
        System.out.println(sol.fractionToDecimal(1, 90));
    }
}
