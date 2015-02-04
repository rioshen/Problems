import java.util.List;

/**
 * Created by Robbert on 2/3/15.
 * Merge k Sorted Lists
 * https://oj.leetcode.com/problems/merge-k-sorted-lists/
 */
public class MergekSortedLists {
    /**
     * TLE, O(N)
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
        } else {
            return mergeHelper(lists, 0, lists.size() - 1);
        }
    }

    private ListNode mergeHelper(List<ListNode> lists, int lo, int hi) {
        if (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            return merge(mergeHelper(lists, lo, mid), mergeHelper(lists, mid + 1, hi));
        }
        return lists.get(lo);
    }


}
