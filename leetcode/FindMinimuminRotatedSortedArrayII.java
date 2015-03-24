/**
 * Created by Robbert on 2/6/15.
 * Find Minimum in Rotated Sorted Array II
 * https://oj.leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
 */
public class FindMinimuminRotatedSortedArrayII {
    /**
     * In worst case (only contains duplicates), binary search is same like linear search.
     */
    public int findMinLinear(int[] num) {
        if (num == null || num.length == 0) throw new IllegalArgumentException();
        int min = Integer.MAX_VALUE;
        for (int elem : num) min = Math.min(elem, min);
        return min;
    }

    /**
     * Two cases, one is there's no duplicates, just like previous problem
     * the other, if there exists duplicates, we can't halve any parts of the
     * array, just update L by 1.
     */
    public int findMin(int[] num) {
        if (num == null || num.length == 0) throw new IllegalArgumentException();
        int lo = 0, hi = num.length - 1;
        while (lo < hi && num[lo] >= num[hi]) {
            int mid = lo + (hi - lo) / 2;
            if (num[hi] < num[mid]) {
                lo = mid + 1;
            } else if (num[lo] > num[mid]) {
                hi = mid;
            } else {
                lo++;
            }
        }
        return num[lo];
    }
}
