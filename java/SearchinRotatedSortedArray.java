/**
 * Created by Robbert on 1/26/15.
 * Search in Rotated Sorted Array
 * https://oj.leetcode.com/problems/search-in-rotated-sorted-array/
 */
public class SearchinRotatedSortedArray {
    public int search(int[] A, int target) {
        if (A == null || A.length == 0) {
            return -1;
        }

        int lo = 0;
        int hi = A.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (A[mid] == target) {
                return mid;
            }

            if (A[lo] <= A[mid]) {
                if (A[lo] <= target && target < A[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else {
                if (A[mid] < target && target <= A[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }

        }
        return -1;
    }
}
