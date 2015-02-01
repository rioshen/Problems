import java.util.LinkedList;
import java.util.List;

/**
 * Created by Robbert on 2/1/15.
 * Path Sum II
 * https://oj.leetcode.com/problems/path-sum-ii/
 */
public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (root == null) {
            return result;
        }
        generateSum(root, sum, new LinkedList<Integer>(), result);
        return result;
    }

    private void generateSum(TreeNode root, int sum, List<Integer> sol, List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null && root.val == sum) {
            sol.add(root.val);
            res.add(new LinkedList<Integer>(sol));
            sol.remove(sol.size() - 1);
            return;
        }
        sol.add(root.val);
        generateSum(root.left, sum - root.val, sol, res);
        generateSum(root.right, sum - root.val, sol, res);
        sol.remove(sol.size() - 1);
    }
}