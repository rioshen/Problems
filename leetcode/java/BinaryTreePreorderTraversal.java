import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Robbert on 1/27/15.
 * Binary Tree Preorder Traversal
 * https://oj.leetcode.com/problems/binary-tree-preorder-traversal/
 */
public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<Integer>();
        if (root == null) {
            return result;
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
            result.add(node.val);
        }

        return result;
    }
}
