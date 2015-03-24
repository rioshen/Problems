public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        ListNode middle = findMiddle(head);
        ListNode second = reverse(middle.next);
        middle.next = null;

        reorder(head, second);
    }

    private void reorder(ListNode l1, ListNode l2) {
        while (l1 != null && l2 != null) {
            ListNode next = l1.next;
            l1.next = l2;
            l2 = l2.next;
            l1.next.next = next;
            l1 = next;
        }
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private ListNode findMiddle(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
