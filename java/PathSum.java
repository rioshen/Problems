/**
 * Created by Robbert on 1/23/15.
 * Path Sum
 * https://oj.leetcode.com/problems/path-sum/
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null && root.val == sum) {
            return true;
        }

        return hasPathSum(root.left, sum - root.val)
                || hasPathSum(root.right, sum - root.val);
    }
}
