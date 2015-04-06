import java.util.*;

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

    public int sumNumbersIter(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int sum = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            if (node.right != null) {
                node.right.val = node.val * 10 + node.right.val;
                stack.push(node.right);
            }
            if (node.left != null) {
                node.left.val = node.val * 10 + node.left.val;
                stack.push(node.left);
            }
            if (node.left == null && node.right == null) {
                sum += node.val;
            }
        }
        return sum;
    }
}
