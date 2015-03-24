import java.util.*;

public class Subsets {
    public List<List<Integer>> subsets(int[] S) {
        if (S == null || S.length == 0) {
            return null;
        }
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(S); // I predict sort the input array only because easy to check the result for oj
        helper(S, 0, new ArrayList<Integer>(), result);
        return result;
    }

    private void helper(int[] arr, int pos, List<Integer> path, List<List<Integer>> res) {
        res.add(new ArrayList<Integer>(path));
        for (int i = pos; i < arr.length; i++) {
            path.add(arr[i]);
            helper(arr, i + 1, path, res);
            path.remove(path.size() - 1);
        }
    }
}
