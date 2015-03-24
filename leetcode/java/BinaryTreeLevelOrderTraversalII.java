import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Robbert on 1/23/15.
 */
public class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new LinkedList<Integer>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                level.add(node.val);
            }
            result.add(level);
        }

        Collections.reverse(result);
        return result;
    }
}
