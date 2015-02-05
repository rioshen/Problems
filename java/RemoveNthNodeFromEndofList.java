/**
 * Created by Robbert on 1/23/15.
 * Remove Nth Node From End of List
 * https://oj.leetcode.com/problems/remove-nth-node-from-end-of-list/
 */
public class RemoveNthNodeFromEndofList {
    /**
     * length = m + n, target is to find n, first move n steps, rest length is m.
     * Start from the head again while moving the first pointer until hit the end
     * which means it moves m, the the second pointer has moved m
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        
        ListNode fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        if (fast == null) {
            // bug 1: head can also be removed
            // {1,2}, 2 -> {2}
            head = head.next;
            return head;
        }

        ListNode slow = head;        
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        
        slow.next = slow.next.next;
        return head;
    }
}
