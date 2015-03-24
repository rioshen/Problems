public class RemoveDuplicatesfromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode curr = dummy;
        dummy.next = head;

        while (curr.next != null) {
            ListNode node = curr.next;
            while (node.next != null && node.val == node.next.val) {
                node = node.next;
            }
            if (node != curr.next) { // duplicate remove
                curr.next = node.next;
            } else {
                curr = curr.next;
            }
        }
        
        return dummy.next;
    }
}