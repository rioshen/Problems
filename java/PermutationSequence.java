import java.util.LinkedList;
import java.util.List;

/**
 * Created by Robbert on 2/3/15.
 * Permutation Sequence
 * https://oj.leetcode.com/problems/permutation-sequence/
 */
public class PermutationSequence {
    /**
     * backtracking - O(n!)
     * TLE: 8, 20545
     */
    public String getPermutationTLE(int n, int k) {
        String res = "";
        if (n < 1) return res;
        generatePermute(n, k, new LinkedList<Integer>(), res);
        return res;
    }

    public void generatePermute(int n, int k, List<Integer> path, String res) {
        if (n == path.size()) {
            if (k == 1) res = path.toString();
            System.out.println(res);
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (path.contains(i)) continue;
            path.add(i);
            generatePermute(n, k - 1, path, res);
            path.remove(path.size() - 1);
        }
    }

    public String getPermutation(int n, int k) {

        List<Character> digits = new LinkedList<Character>();


        for (char i = '1'; i <= '0' + n; i++) {
            digits.add(i);
        }

        k = k - 1;
        StringBuilder sb = new StringBuilder();

        int sum = 1;

        for (int i = 1; i <= n; i++) {
            sum *= i;
        }

        int cur = n;
        while (!digits.isEmpty()) {
            sum /= cur;
            cur--;

            int digitIndex = k / sum;
            k = k % sum;

            sb.append(digits.get(digitIndex));

            digits.remove(digitIndex);
        }

        return sb.toString();
    }

}
