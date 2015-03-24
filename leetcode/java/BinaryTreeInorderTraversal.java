import java.util.*;

public class BinaryTreeInorderTraversal {
    public List<Integer> inorder(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if (root == null) return result;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (!stack.isEmpty() || curr != null) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                curr = stack.pop();
                result.add(curr.val);
                curr = curr.right;
            }
        }
        return result;
    }
}
