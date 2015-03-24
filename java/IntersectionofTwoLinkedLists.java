import java.util.*;

/**
 * Created by Carl Shen on 1/23/15.
 * Intersection of Two Linked Lists
 * https://oj.leetcode.com/problems/intersection-of-two-linked-lists/
 */
public class IntersectionofTwoLinkedLists {
    /**
     * Simple solution is first scan list a and use a set to store elements we met
     * After that scan list b, the first node we can find in the set is the intersection.
     * Time O(N), Space O(N)
     */
    public ListNode getIntersectionNodeSet(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)  return null;
        Set<ListNode> set = new HashSet<ListNode>();
        ListNode curr = headA;
        while (curr != null) {
            set.add(curr);
            curr = curr.next;
        }
        curr = headB;
        while (curr != null) {
            if (!set.add(curr)) return curr;
            curr = curr.next;
        }
        return null;
    }

    /**
     * Use two pointer to iterate two lists at the same time, if they have same length
     * two pointers may point to same node, and it is the intersection.
     * Because of this, we can first calculate the length of each, make them start from the same position
     * once they met, return that node
     */
     private int length(ListNode node) {
         int len = 0;
         while (node != null) {
             len++;
             node = node.next;
         }
         return len;
     }

     public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
         if (headA == null || headB == null) {
             return null;
         }
         int lenA = length(headA), lenB = length(headB);
         if (lenA > lenB) {
             return getIntersectionNode(headB, headA);
         }
         for (int i = lenB - lenA; i > 0; i--) {
             headB = headB.next;
         }
         while (headA != headB) {
             headA = headA.next;
             headB = headB.next;
         }
         return headA;
     }

     /**
      * Didn't accept, because OJ detected that I modified the
      * internal data structure, I tried to avoid that, but still got caught.
      * We can also point the tail to head of B, then we have a cycle
      * So right now our target is to find the cycle node
      */
     public ListNode getIntersectionNodeModification(ListNode headA, ListNode headB) {
         if (headA == null || headB == null) return null;
         ListNode tail = headA;
         while (tail.next != null) {
             tail = tail.next;
         }
         tail.next = headB;

         ListNode fast = headA;
         ListNode slow = headA;
         while (fast != null && fast.next != null) {
             slow = slow.next;
             fast = fast.next.next;
             if (slow == fast) {
                 slow = headA;
                 while (slow != fast) {
                     fast = fast.next;
                     slow = slow.next;
                 }
                 return slow;
             }
         }

         // bug 1: OJ doesn't allow to modify the linked structure.
         tail.next = null;
         return null;
     }
}
