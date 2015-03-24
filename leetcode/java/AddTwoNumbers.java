/**
 * Created by Rio on 1/4/15.
 * Add Two Numbers
 * https://oj.leetcode.com/problems/add-two-numbers/
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode current = result;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int sums = carry;
            sums += l1 != null ? l1.val : 0;
            sums += l2 != null ? l2.val : 0;

            carry = sums / 10;
            current.next = new ListNode(sums % 10);

            current = current.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        current.next = carry == 0 ? null : new ListNode(carry);

        return result.next;
    }
}
