/**
 * Created by Robbert on 1/25/15.
 * Merge Two Sorted Lists
 * https://oj.leetcode.com/problems/merge-two-sorted-lists/
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null){
            reutrn l1;
        }

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        while (l1 != null || l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
            } else {

            }

        }
    }
}
