import java.util.LinkedList;
import java.util.List;

/**
 * Created by Robbert on 2/3/15.
 * Unique Binary Search Trees II
 * https://oj.leetcode.com/problems/unique-binary-search-trees-ii/
 */
public class UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
        ///  if (n <= 0) return null; // reasonable but doesn't allow null output
        return generate(1, n);
    }

    public List<TreeNode> generate(int start, int end) {
        List<TreeNode> res = new LinkedList<TreeNode>();
        if (start > end) {
            res.add(null);
            return res;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> left = generate(start, i - 1);
            List<TreeNode> right = generate(i + 1, end);
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }
        }

        return res;
    }
}
