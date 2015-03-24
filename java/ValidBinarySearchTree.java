import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Carl Shen on 1/6/15.
 */
public class ValidBinarySearchTree {
    private List<Integer> inorder(TreeNode root) {
        List<Integer> result = new LinkedList<Integer>();
        if (root == null) {
            return result;
        }

        result.addAll(inorder(root.left));
        result.add(root.val);
        result.addAll(inorder(root.right));

        return result;
    }

    public boolean validateBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        List<Integer> result = inorder(root);

        for (int i = 1; i < result.size(); i++) {
            if (result.get(i) <= result.get(i - 1)) {
                return false;
            }
        }

        return true;
    }

    public boolean isValidBSTiter(TreeNode root) {
        if (root == null) return true;
        TreeNode curr = root, prev = null;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || curr != null) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                curr = stack.pop();
                if (prev != null && curr.val <= prev.val) {
                    return false;
                }
                prev = curr;
                curr = curr.right;
            }
        }
        return true;
    }
}
