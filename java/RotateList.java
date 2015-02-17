/**
 * Created by Robbert on 2/1/15.
 * Rotate List
 * https://oj.leetcode.com/problems/rotate-list/
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int n) {
        if (head == null || n == 0) {
            return head;
        }

        int length = getLength(head);
        n = n % length; // n is greater than the length;

        ListNode dummy = new ListNode(Integer.MAX_VALUE);
        dummy.next = head;
        head = dummy;
        while (n != 0) {
            head = head.next;
            n--;
        }
        ListNode tail = dummy;
        while (head.next != null) {
            tail = tail.next;
            head = head.next;
        }
        head.next = dummy.next; // point to the original head
        dummy.next = tail.next;
        tail.next = null;

        return dummy.next;
    }

    public int getLength(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }
}
