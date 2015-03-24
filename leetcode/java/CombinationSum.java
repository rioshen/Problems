import java.util.*;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return res;
        Arrays.sort(candidates);
        helper(candidates, target, 0, new ArrayList<Integer>(), res);
        return res;
    }

    public void helper(int[] nums, int sum, int pos, List<Integer> path, List<List<Integer>> res) {
        if (sum == 0) {
            res.add(new ArrayList<Integer>(path));
            return;
        }

        for (int i = pos; i < nums.length; i++) {
            int num = nums[i];
            if (num > sum) continue;
            path.add(num);
            helper(nums, sum - num, i, path, res);
            path.remove(path.size() - 1);
        }
    }
}
