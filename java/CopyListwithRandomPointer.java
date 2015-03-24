class RandomListNode {
    int label;
    RandomListNode next, random;
    RandomListNode(int x) { this.label = x; }
};
/**
 * Created by Carl Shen on 1/31/15.
 * Copy List with Random Pointer
 * https://oj.leetcode.com/problems/copy-list-with-random-pointer/
 */
public class CopyListwithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;

        RandomListNode curr = head;
        while (curr != null) {
            RandomListNode temp = new RandomListNode(curr.label);
            temp.next = curr.next;
            curr.next = temp;
            curr = temp.next;
        }

        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        curr = head;
        RandomListNode copy = curr.next;
        while (curr.next != null) {
            RandomListNode temp = curr.next;
            curr.next = temp.next;
            curr = temp;
        }

        return copy;
    }
}
