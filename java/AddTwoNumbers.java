/**
 * Created by Robbert on 1/4/15.
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

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode result = new AddTwoNumbers().addTwoNumbers(l1, l2);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
