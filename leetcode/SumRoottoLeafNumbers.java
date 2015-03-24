public class SumRoottoLeafNumbers {
    public int sumNumbers(TreeNode root) {
        return root == null ? 0 : pathSum(root, 0);
    }
    
    private int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }

        sum = sum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        }

        return pathSum(root.left, sum) + pathSum(root.right, sum);
    }
}