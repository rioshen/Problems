public class ReverseNodesinKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) return head;
         
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        
        int i = 1;
        while (head != null) {
            if (i % k == 0) {
                prev = reverse(prev, head.next);
                head = prev.next;
            } else {
                head = head.next;
            }
            i++;
        }
        return dummy.next;
    }
    
    private ListNode reverse(ListNode head, ListNode tail) {
        ListNode prev = head.next;
        ListNode curr = prev.next;
        while (curr != tail) {
            prev.next = curr.next;
            curr.next = head.next;
            head.next = curr;
            curr = prev.next;
        }
        return prev;
    }
}