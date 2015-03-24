import java.util.HashSet;
import java.util.Set;

/**
 * Created by Robbert on 1/27/15.
 * Linked List Cycle II
 * https://oj.leetcode.com/problems/linked-list-cycle-ii/
 */
public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        Set<ListNode> set = new HashSet<ListNode>();
        while (head != null && set.add(head)) {
            head = head.next;
        }

        return head == null ? null : head;
    }

    public ListNode detectCycleTwoPointers(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}
