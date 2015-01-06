import java.util.LinkedList;
import java.util.List;

/**
 * Created by terry on 1/6/15.
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
}
