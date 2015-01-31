/**
 * Created by Robbert on 1/31/15.
 * Find Minimum in Rotated Sorted Array
 * https://oj.leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 */
public class FindMinimuminRotatedSortedArray {
    public int findMinLinear(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int elem : num) {
            min = Math.min(elem, min);
        }
        return min;
    }
}
