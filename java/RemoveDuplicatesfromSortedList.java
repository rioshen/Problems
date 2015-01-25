/**
 * Created by Robbert on 1/25/15.
 * Remove Duplicates from Sorted List
 * https://oj.leetcode.com/problems/remove-duplicates-from-sorted-list/
 */
public class RemoveDuplicatesfromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode curr = head;
        while (curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }

        return head;
    }

}
