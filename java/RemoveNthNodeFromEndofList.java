/**
 * Created by Robbert on 1/23/15.
 * Remove Nth Node From End of List
 * https://oj.leetcode.com/problems/remove-nth-node-from-end-of-list/
 */
public class RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode curr = dummy;
        for (int i = 0; i < n; i++) {
            if (curr.next == null) {
                return dummy.next;
            }
            curr = curr.next;
        }

        ListNode slow = dummy;
        while (curr.next != null) {
            slow = slow.next;
            curr = curr.next;
        }
        slow.next = slow.next.next;

        return dummy.next;
    }
}
