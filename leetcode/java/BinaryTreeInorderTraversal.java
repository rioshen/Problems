import java.util.*;

public class BinaryTreeInorderTraversal {
    public List<Integer> inorder(TreeNode root) {
        if (root == null) {
            return new LinkedList<Integer>();
        }

        TreeNode curr = root;
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();

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
