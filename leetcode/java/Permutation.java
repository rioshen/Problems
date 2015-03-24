import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Robbert on 1/31/15.
 * Permutations
 * https://oj.leetcode.com/problems/permutations/
 */
public class Permutation {
    public List<List<Integer>> permute(int[] num) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (num == null || num.length == 0) {
            return result;
        }

        Arrays.sort(num);
        generatePermutation(num, new LinkedList<Integer>(), result);
        return result;
    }

    private void generatePermutation(int[] num, List<Integer> sol,
                                     List<List<Integer>> res)
    {
        if (sol.size() == num.length) {
            res.add(new LinkedList<Integer>(sol));
            return;
        }

        for (int i = 0; i < num.length; i++) {
            if (sol.contains(num[i])) {
                continue;
            }
            sol.add(num[i]);
            generatePermutation(num, sol, res);
            sol.remove(sol.size() - 1);
        }
    }
}
