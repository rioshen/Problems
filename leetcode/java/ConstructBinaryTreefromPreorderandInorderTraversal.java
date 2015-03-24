/**
 * Created by Robbert on 2/3/15.
 * Construct Binary Tree from Preorder and Inorder Traversal
 * https://oj.leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
public class ConstructBinaryTreefromPreorderandInorderTraversal {
    /**
     *       2
     *      / \
     *     1   3
     *    / \  / \
     *   4   5 10 11
     * preorder: 2(root) 1 4 5 3 10 11 -> root node is always the first element.
     * inorder: 4 1 5 2(root) 10 3 11 -> left subtree and right subtree is nested to the root
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) {
            return null;
        } else {
            return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        }
    }

    private TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);

        int current = find(inorder, preorder[preStart], inStart, inEnd);
        int left = current - inStart;
        root.left = build(preorder, preStart + 1, preStart + left, inorder, inStart, current - 1);
        root.right = build(preorder, preStart + left + 1, preEnd, inorder, current + 1, inEnd);

        return root;
    }

    private int find(int[] inorder, int val, int inStart, int inEnd) {
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == val) return i;
        }
        return -1;
    }
}
