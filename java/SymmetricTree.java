import java.util.Stack;

/**
 * Created by Robbert on 1/23/15.
 * Symmetric Tree
 * https://oj.leetcode.com/problems/symmetric-tree/
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return checkSymmetric(root.left, root.right);
        }
    }

    private boolean checkSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null || left.val != right.val) {
            return false;
        }

        return checkSymmetric(left.left, right.right)
                && checkSymmetric(left.right, right.left);
    }

    public boolean isSymmetricIteration(TreeNode root) {
        if (root == null) {
            return true;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root.right);
        stack.push(root.left);
        while (!stack.isEmpty()) {
            TreeNode left = stack.pop();
            TreeNode right = stack.pop();
            if (left == null && right == null) {
                continue;
            }
            if (left == null || right == null || left.val != right.val) {
                return false;
            }
            stack.push(right.left);
            stack.push(left.right);
            stack.push(right.right);
            stack.push(left.left);
        }

        return true;
    }
}
