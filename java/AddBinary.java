/**
 * Created by Robbert on 1/25/15.
 * Add Binary
 * https://oj.leetcode.com/problems/add-binary/
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        if (a == null || a.length() == 0) {
            return b;
        } else if (b == null || b.length() == 0) {
            return a;
        }

        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        String result = "";
        while (i >= 0 || j >= 0) {
            int x = i >= 0 ? a.charAt(i) - '0' : 0;
            int y = j >= 0 ? b.charAt(j) - '0' : 0;
            int sum = x + y + carry;
            carry = sum / 2;
            result = String.valueOf(sum % 2) + result;
            i--;
            j--;
        }
        if (carry > 0) {
            result = String.valueOf(carry) + result;
        }
        return result;
    }
}
