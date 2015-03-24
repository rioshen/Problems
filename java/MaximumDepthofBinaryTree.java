/**
 * Created by Robbert on 1/23/15.
 * Maximum Depth of Binary Tree
 * https://oj.leetcode.com/problems/maximum-depth-of-binary-tree/
 */
public class MaximumDepthofBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left, right) + 1;
    }
}
