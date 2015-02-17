/**
 * Created by Robbert on 2/2/15.
 * Convert Sorted List to Binary Search Tree
 * https://oj.leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
 */
public class ConvertSortedListtoBinarySearchTree {
    /**
     * O(N*logN), Time Limit Exceeded
     * The run time complexity is clearly O(N lg N), where N is the total number
     * of elements in the list. This is because each level of recursive call
     * requires a total of N/2 traversal steps in the list, and there are a
     * total of lg N number of levels (ie, the height of the balanced tree).
     */
    public TreeNode sortedListToBSTTLE(ListNode head) {
        if (head == null) {
            return null;
        } else {
            return buildBST(head, 0, getLength(head));
        }
    }

    private TreeNode buildBST(ListNode head, int lo, int hi) {
        if (lo >= hi) {
            return null;
        }

        int mid = lo + (hi - lo) / 2; // avoid integer overflow
        ListNode middle = findMiddle(head, mid);

        TreeNode root = new TreeNode(middle.val);
        root.left = buildBST(head, lo, mid - 1);
        root.right = buildBST(head, mid + 1, hi);

        return root;
    }

    private ListNode findMiddle(ListNode head, int pos) {
        while (pos > 0) {
            head = head.next;
            pos--;
        }
        return head;
    }

    private int getLength(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }

    /**
     * Accepted solution, O(N)
     */
    private ListNode current = null;
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        } else {
            current = head;
            return buildBST(0, getLength(head) - 1);
        }
    }

    private TreeNode buildBST(int lo, int hi) {
        if (lo > hi) {
            return null;
        }
        int mid = lo + (hi - lo) / 2; // avoid integer overflow
        TreeNode left = buildBST(lo, mid - 1);
        TreeNode root = new TreeNode(current.val);
        root.left = left;
        current = current.next;
        TreeNode right = buildBST(mid + 1, hi);
        root.right = right;
        return root;
    }
}
