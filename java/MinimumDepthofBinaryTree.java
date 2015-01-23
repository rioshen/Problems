/**
 * Created by Robbert on 1/23/15.
 */
public class MinimumDepthofBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return minHeight(root);
        }
    }

    private int minHeight(TreeNode root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        int left = minHeight(root.left);
        int right = minHeight(root.right);

        return Math.min(left, right) + 1;
    }

}
