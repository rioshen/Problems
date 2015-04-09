public class SwapNodesinPairs {
    // iteration
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while (head != null && head.next != null) {
            ListNode first = head;
            ListNode second = head.next;
            ListNode next = head.next.next;

            first.next = second.next;
            second.next = first;
            curr.next = second;

            head = next;
            curr = first;
        }

       return dummy.next;
    }

    // recursive
    public ListNode SwapNodesinPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = head.next;
        head.next = SwapNodesinPairs(newHead.next);
        newHead.next = head;
        return newHead;
    }
}
