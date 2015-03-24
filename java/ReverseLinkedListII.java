/**
 * Created by Robbert on 2/2/15.
 * Reverse Linked List II
 * https://oj.leetcode.com/problems/reverse-linked-list-ii/
 */
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) return null;

        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode curr = dummy;
        for (int i = 1; i < m; i++) {
            curr = curr.next;
        }

        ListNode tail = dummy.next;
        for (int i = 1; i < n; i++) {
            tail = tail.next;
        }

        curr.next = reverse(curr.next, tail, n - m + 1);

        return dummy.next;
    }

    private ListNode reverse(ListNode start, ListNode end, int len) {
        ListNode prev = end.next;
        ListNode current = start;
        while (len != 0) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            len--;
        }
        return prev;
    }
}
