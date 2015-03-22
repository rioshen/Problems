import java.util.*;

public class SubsetsII {
    public List<List<Integer>> setsetsWithDup(int[] num) {
        if (num == null || num.length == 0) return null;

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(num);
        helper(num, 0, new ArrayList<Integer>(), result);
        return result;
    }

    private void helper(int[] num, int pos, List<Integer> path, List<List<Integer>> res) {
        res.add(new ArrayList<Integer>(path));

        for (int i = pos; i < num.length; i++) {
            if (i != pos && num[i] == num[i - 1]) continue;

            path.add(num[i]);
            helper(num, i + 1, path, res);
            path.remove(path.size() - 1);
        }
    }
}
