/**
 * Created by terry on 1/6/15.
 */
public class StringInteger {
    public int atoi(String number) {
        if (number == null || number.length() == 0) {
            return 0;
        }

        number = number.trim();
        if (number.length() == 0) { // only spaces
            return 0;
        }

        int position = (number.charAt(0) == '+' || number.charAt(0) == '-') ? 1 : 0;
        boolean negative = (number.charAt(0) == '-');
        long result = 0;
        while (position < number.length()) {
            char ch = number.charAt(position);
            if (ch < '0' || ch > '9')  {
                break;
            }
            result = result * 10 + ch - '0';
            if (!negative && result > Integer.MAX_VALUE) break;
        }

        if (negative && -result < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        if (!negative && result > Integer.MAX_VALUE) return Integer.MAX_VALUE;

        if (negative) result = -result;
        return (int)result;
    }
}
