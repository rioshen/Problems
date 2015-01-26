/**
 * Created by Robbert on 1/4/15.
 * Add Two Numbers
 * https://oj.leetcode.com/problems/add-two-numbers/
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        ListNode result = new ListNode(Integer.MIN_VALUE);
        ListNode current = result;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int sums = carry;
            sums += l1 != null ? l1.val : 0;
            sums += l2 != null ? l2.val : 0;

            carry = sums / 10;
            sums = sums % 10;
            current.next = new ListNode(sums);

            current = current.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }

        current.next = carry == 0 ? null : new ListNode(carry);

        return result.next;
    }
}
