import java.util.HashSet;
import java.util.Set;

/**
 * Created by Robbert on 1/27/15.
 * Linked List Cycle
 * https://oj.leetcode.com/problems/linked-list-cycle/
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        Set<ListNode> set = new HashSet<ListNode>();
        ListNode current = head;
        while (set.add(current) && current != null) {
            current = current.next;
        }

        return current == null ? false : true;
    }

    public boolean hasCycleTwoPointers(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }

        return false;
    }
}
