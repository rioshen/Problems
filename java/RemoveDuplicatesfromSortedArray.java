/**
 * Created by Robbert on 1/25/15.
 * Remove Duplicates from Sorted Array
 * https://oj.leetcode.com/problems/remove-duplicates-from-sorted-array/
 */
public class RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] A) {
        if (A == null || A.length == 0) return 0;
        int idx = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[idx] != A[i]) {
                // bug 1: idx++ will cause overwrite, [1, 2] -> [2, 2]
                // A[idx++] = A[i];
                A[++idx] = A[i];
            }
        }
        return idx + 1;
    }
}
