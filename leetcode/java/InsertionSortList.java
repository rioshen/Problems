/**
 * Created by Robbert on 2/3/15.
 * Insertion Sort List
 * https://oj.leetcode.com/problems/insertion-sort-list/
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        while (head != null) {
            ListNode prev = dummy;
            while (prev.next != null && prev.next.val <= head.val) {
                prev = prev.next;
            }

            ListNode next = head.next;
            head.next = prev.next;
            prev.next = head;

            head = next;
        }

        return dummy.next;
    }
}
