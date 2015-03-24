/**
 * Created by Robbert on 2/3/15.
 * Construct Binary Tree from Inorder and Postorder Traversal
 * https://oj.leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 */
public class ConstructBinaryTreefromInorderandPostorderTraversal {
    /**
     *     7
     *    / \
     *   4   10
     *  / \  / \
     * 3  5 11 13
     * inorder: 3 4 5 7(root) 11 10 13  : inorder start index - root index = left subtree range
     * postorder: 3 5 4 11 13 10 7(root) : root is always at the end, subroot
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null)  {
            return null;
        } else {
            return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
        }
    }

    public TreeNode build(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[postEnd]);
        int current = find(inorder, postorder[postEnd], inStart, inEnd);
        int left = current - inStart;
        root.left = build(inorder, inStart, current - 1, postorder, postStart, postStart + left - 1);
        root.right = build(inorder, current + 1, inEnd, postorder, postStart + left, postEnd - 1);

        return root;
    }

    public int find(int[] inorder, int val, int start, int end) {
        for (int i = start; i <= end; i++) if (inorder[i] == val) return i;
        return -1;
    }
}
