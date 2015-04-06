import java.util.*;

/**
 * Created by Robbert on 2/3/15.
 * Merge k Sorted Lists
 * https://oj.leetcode.com/problems/merge-k-sorted-lists/
 */
public class MergekSortedLists {
    /**
     * TLE, O(Nk^2)
     * @param lists
     * @return
     */
    public ListNode mergeKListsTLE(List<ListNode> lists) {
        if (lists == null || lists.size() == 0) return null;

        ListNode res = lists.get(0);
        for (int i = 1; i < lists.size(); i++) {
            res = merge(res, lists.get(i));
        }
        return res;
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode curr = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        curr.next = l1 == null ? l2 : l1;

        return dummy.next;
    }

    /**
     * Merge Sort, Accept, O(n*k*logk)
     * @param lists
     * @return
     */
    public ListNode mergeKListsMergeSort(List<ListNode> lists) {
        if (lists == null || lists.size() == 0) {
            return null;
        }

        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.size(), new Comparator<ListNode>(){
            @Override
            public int compare(ListNode l1, ListNode l2) {
                return l1.val - l2.val;
            }
        });
        for (ListNode list : lists) {
            if (list != null) {
                queue.offer(list);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while (!queue.isEmpty()) {
            ListNode head = queue.poll();
            curr.next = head;
            if (head.next != null) queue.offer(head.next);
            curr = curr.next;
        }
        return dummy.next;
    }
}
