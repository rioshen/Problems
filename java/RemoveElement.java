/**
 * Created by Robbert on 1/25/15.
 * Remove Element
 * https://oj.leetcode.com/problems/remove-element/
 */
public class RemoveElement {
    public int removeElement(int[] A, int elem) {
        if (A == null || A.length == 0) {
            return 0;
        }

        int left = 0;
        int right = 0;
        while (right < A.length) {
            if (A[right] != elem) {
                A[left++] = A[right];
            }
            right++;
        }

        return left;
    }
}
