public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;
        
        ListNode leftDummy = new ListNode(Integer.MIN_VALUE);
        ListNode left = leftDummy;
        ListNode rightDummy = new ListNode(Integer.MIN_VALUE);
        ListNode right = rightDummy;
        
        while (head != null) {
            if (head.val < x) {
                left.next = head;
                left = left.next;
            } else {
                right.next = head;
                right = right.next;
            }
            head = head.next;
        }

        left.next = rightDummy.next;
        right.next = null;

        return leftDummy.next;
    }
}