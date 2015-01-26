/**
 * Created by Robbert on 1/26/15.
 * Search Insert Position
 * https://oj.leetcode.com/problems/search-insert-position/
 */
public class SearchInsertPosition {
    public int searchInsert(int[] A, int target) {
        if (A == null || A.length == 0) {
            throw new IllegalArgumentException();
        }

        int lo = 0;
        int hi = A.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (A[mid] == target) {
                return mid;
            } else if (A[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        return lo;
    }
}
