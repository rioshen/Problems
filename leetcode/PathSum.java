import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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

    public boolean hasPathSumDFS(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<Integer> path = new Stack<Integer>();
        stack.push(root);
        path.push(root.val);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            int pathSum = path.pop();
            if (node.left == null && node.right == null && pathSum == sum) {
                return true;
            }
            if (node.right != null) {
                stack.push(node.right);
                path.push(node.right.val + pathSum);
            }
            if (node.left != null) {
                stack.push(node.left);
                path.push(node.left.val + pathSum);
            }
        }

        return false;
    }

    public boolean hasPathSumBFS(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Queue<Integer> path = new LinkedList<Integer>();
        queue.offer(root);
        path.offer(root.val);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int pathSum = path.poll();
            if (node.left == null && node.right == null && pathSum == sum) {
                return true;
            }
            if (node.left != null) {
                queue.offer(node.left);
                path.offer(node.left.val + pathSum);
            }
            if (node.right != null) {
                queue.offer(node.right);
                path.offer(node.right.val + pathSum);
            }
        }
        return false;
    }
}
