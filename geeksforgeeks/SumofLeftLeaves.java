class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    public TreeNode(int x) { val = x; }
}

public class SumofLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int sum = 0;
        if (root.left != null 
            && root.left.left == null 
            && root.left.right == null)
        {
            sum += root.left.val;
        }
        sum += sumOfLeftLeaves(root.left);
        sum += sumOfLeftLeaves(root.right);

        return sum;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.left = new TreeNode(10);
        // the sum should e 4 + 10 = 14
        SumofLeftLeaves sol = new SumofLeftLeaves();
        System.out.println(sol.sumOfLeftLeaves(root));
    }
}

