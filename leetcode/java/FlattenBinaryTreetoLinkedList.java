import java.util.Stack;

/**
 * Created by Carl Shen on 1/26/15.
 * Flatten Binary Tree to Linked List
 * https://oj.leetcode.com/problems/flatten-binary-tree-to-linked-list/
 */
public class FlattenBinaryTreetoLinkedList {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
            node.left = null;
            if (!stack.isEmpty()) {
                node.right = stack.peek();
            }
        }
    }

    public void flattenInplace(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                if (curr.right != null) {
                    TreeNode next = curr.left;
                    while (next.right != null) {
                        next = next.right;
                    }
                    next.right = curr.right;
                }
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
    }

    public void flattenRec(TreeNode root) {
        if (root == null) return;
        TreeNode left = root.left, right = root.right;
        root.left = null;
        flattenRec(left);
        flattenRec(right);
        root.right = left;

        TreeNode curr = root;
        while (curr.right != null) curr = curr.right;
        curr.right = right;
    }
}
