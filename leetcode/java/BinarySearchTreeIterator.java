import java.util.*;

public class BSTIterator {
    private TreeNode current;
    private Stack<TreeNode> stack = new Stack<TreeNode>();

    public BSTIterator(TreeNode root) {
        current = root;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty() || current != null;
    }

    /** @return the next smallest number */
    public int next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        } else {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            TreeNode node = stack.pop();
            current = node.right;
            return node.val;
        }
    }
}