// Implement the reversal of a singly linked list iteratively and recursively.
// http://leetcode.com/2010/04/reversing-linked-list-iteratively-and.html
// Declare a previous pointer and initialize it as null, and then reverse
// linked node one by one
class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) { this.val = val; }
}

public class ReverseLinkedList {
    public ListNode reverse(ListNode head) {
        if (head == null) {
            return null; 
        } 

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

    public void reverseRecur(ListNode head) {
        if (head == null) return;

        ListNode next = head.next;
        if (next == null) {
            return; 
        }

        reverseRecur(next);
        head.next.next = head;
        head.next = null;
        head = next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }

        ReverseLinkedList sol = new ReverseLinkedList();
        current = sol.reverse(head);
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();

        sol.reverseRecur(head);
        current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        
    }
}
