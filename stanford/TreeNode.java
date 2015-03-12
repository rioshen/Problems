public class TreeNode {
    public int value;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int data) { this.value = data; }

    public TreeNode(int data, TreeNode left, TreeNode right) {
        this.value = data;
        this.left = left;
        this.right = right;
    }
}
