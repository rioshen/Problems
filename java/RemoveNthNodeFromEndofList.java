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
        while (n >= 1 && fast != null) {
            fast = fast.next;
            n--;
        }
        if (n == 0 && fast == null) {
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
