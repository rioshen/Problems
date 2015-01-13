import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int x) { this.val = x; }
}

public class BinarySearchTreeIterator {
    private Stack<Integer> nodes = new Stack<Integer>();

    public BinarySearchTreeIterator(TreeNode root) {
        if (root == null) {
            return; 
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> result = new ArrayList<Integer>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                current = stack.pop();
                result.add(current.val);
                current = current.right;
            }
        }

        Collections.reverse(result);
        for (int entry : result) {
            nodes.push(entry);
        }
    }

    public boolean hasNext() {
        return !nodes.isEmpty();
    }
    
    public int next() {
        return nodes.pop();
    }
}
