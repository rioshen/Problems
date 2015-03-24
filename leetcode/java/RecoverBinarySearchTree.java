public class RecoverBinarySearchTree {
    private TreeNode first;
    private TreeNode second;
    private TreeNode lastNode = new TreeNode(Integer.MIN_VALUE);

    public void recoverTree(TreeNode root) {
        inorderTraversal(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    
    private void inorderTraversal(TreeNode root) {
        if (root == null) return;
        
        inorderTraversal(root.left);
        
        if (first == null && root.val < lastNode.val) {
            first = lastNode;
        }
        if (first != null && root.val < lastNode.val) {
            second = root;
        }
        lastNode = root;
        
        inorderTraversal(root.right);
    }
}