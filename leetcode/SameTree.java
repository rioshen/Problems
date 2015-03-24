import java.util.Stack;

/**
 * Created by Robbert on 1/23/15.
 * Same Tree
 * https://oj.leetcode.com/problems/same-tree/
 */
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null || p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public boolean isSameTreeIteration(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(q);
        stack.push(p);
        while (!stack.isEmpty()) {
            TreeNode left = stack.pop();
            TreeNode right = stack.pop();
            if (left == null && right == null) {
                continue;
            }
            if (left == null || right == null || left.val != right.val) {
                return false;
            }
            stack.push(right.right);
            stack.push(left.right);
            stack.push(right.left);
            stack.push(left.left);
        }

        return true;
    }
}
