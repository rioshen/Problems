class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    public TreeNode(int val) { this.val = val; }
}

// Lowest Common Ancestor in a Binary Tree
// http://www.fusu.us/2013/06/p2-lowest-common-ancestor-in-binary-tree.html

public class LCA {
    public TreeNode lowestCommonAncestor(TreeNode root,
                                         TreeNode p, TreeNode q)
    {
        if (root == null) {
            return null;
        }
        
        if (root.val == p.val || root.val == q.val) {
            return root;
        }
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        
        if (left != null) {
            return left;
        } else {
            return right;
        }
    }
    
    public static void main(String[] args) {
        LCA solution = new LCA();
        // test cases for LCA
        TreeNode root = new TreeNode(3);
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(4);
        root.left = a;
        root.right = b;
        System.out.println(solution.lowestCommonAncestor(root, a, b).val); // 3
        TreeNode c = new TreeNode(7);
        TreeNode d = new TreeNode(5);
        a.left = c;
        a.right = d;
        System.out.println(solution.lowestCommonAncestor(root, c, d).val); // 2
    }
}