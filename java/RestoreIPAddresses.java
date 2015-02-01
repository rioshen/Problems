import java.util.LinkedList;
import java.util.List;

/**
 * Created by Robbert on 2/1/15.
 * Restore IP Addresses
 * https://oj.leetcode.com/problems/restore-ip-addresses/
 */
public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new LinkedList<String>();
        if (s == null || s.length() < 4 || s.length() > 12) {
            return res;
        }

        List<String> sol = new LinkedList<String>();
        generateIPAddress(s, 0, sol, res);
        return res;
    }

    public void generateIPAddress(String s, int pos, List<String> sol, List<String> res) {
        if (sol.size() == 4 && pos == s.length()) {
            res.add(buildIP(sol));
            return;
        }

        for (int i = pos; i < s.length() && i <= pos + 3; i++) {
            String prefix = s.substring(pos, i + 1);
            if (isValidIP(prefix)) {
                sol.add(prefix);
                generateIPAddress(s, i + 1, sol, res);
                sol.remove(sol.size() - 1);
            }
        }
    }

    private String buildIP(List<String> sol) {
        StringBuilder address = new StringBuilder();
        for (String elem : sol) {
            address.append(elem).append(".");
        }
        address.deleteCharAt(address.length() - 1);
        return address.toString();
    }

    private boolean isValidIP(String address) {
        if (address.charAt(0) == '0') {
            return address.equals("0");
        }
        int digit = Integer.parseInt(address);
        return digit >= 0 && digit <= 255;
    }
}
