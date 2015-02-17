public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        ListNode middle = findMiddle(head);
        ListNode second = reverse(middle.next);
        middle.next = null;
        
        reorder(head, second);
    }

    private void reorder(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return;

        ListNode curr = new ListNode(Integer.MIN_VALUE);
        int cnt = 1;
        while (l1 != null && l2 != null) {
            if (cnt % 2 != 0) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            cnt++;
            curr = curr.next;
        }

        curr.next = l1 == null ? l2 : l1;
    }
    
    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode prev = null;
        ListNode curr = head;
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