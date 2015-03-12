import java.util.List;
import java.util.ArrayList;

public class BinaryTree {

    public boolean lookup(TreeNode root, int element) {
         if (root == null) {
            return false;
        }

        if (element < root.value) {
            return lookup(root.left, element);
        } else if (element > root.value) {
            return lookup(root.right, element);
        } else {
            return true;
        }
    }

    public int size(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return size(root.left) + size(root.right) + 1;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

    public int minValue(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        return root.left == null ? root.value : minValue(root.left);
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return (sum == 0);
        }
        sum -= root.value;
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }

    public void printPaths(TreeNode root) {
        int[] path = new int[100];
        printPathsHelper(root, path, 0);
    }

    public void printPathsHelper(TreeNode root, int[] path, int len) {
        if (root == null) {
            return;
        }

        path[len++] = root.value;

        if (root.left == null && root.right == null) {
            for (int i = 0; i < len; i++) System.out.print(path[i] + " ");
            System.out.println();
        } else {
            printPathsHelper(root.left, path, len);
            printPathsHelper(root.right, path, len);
        }
    }

    public void mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        mirror(root.left);
        mirror(root.right);
        TreeNode node = root.left;
        root.left = root.right;
        root.right = node;
    }

    public void printHelper(TreeNode root) {
        if (root == null) return;
        printHelper(root.left);
        System.out.print(root.value);
        printHelper(root.right);
    }

    public static void main (String[] args) {
        //@Before
        //       4
        //      / \
        //     2   5
        //    / \
        //   1   3
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        BinaryTree sol = new BinaryTree();
        System.out.println(sol.lookup(root, 5));
        System.out.println(sol.lookup(root, 10));

        System.out.println(sol.size(root));
        System.out.println(sol.maxDepth(root));
        System.out.println(sol.minValue(root));

        System.out.println(sol.hasPathSum(root, 9));
        System.out.println(sol.hasPathSum(root, 7));
        System.out.println(sol.hasPathSum(root, 6));

        sol.printPaths(root);

        sol.printHelper(root);
        System.out.println();
        sol.mirror(root);
        sol.printHelper(root);
    }
}
