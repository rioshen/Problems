/**
 * Created by Robbert on 1/25/15.
 * Remove Duplicates from Sorted Array
 * https://oj.leetcode.com/problems/remove-duplicates-from-sorted-array/
 */
public class RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        int number = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[number] != A[i]) {
                A[number++] = A[i];
            }
        }

        return number + 1;
    }
}
