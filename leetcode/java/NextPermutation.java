/**
 * Created by Robbert on 2/1/15.
 * Next Permutation
 * https://oj.leetcode.com/problems/next-permutation/
 */
public class NextPermutation {
    public void nextPermutation(int[] num) {
        if (num == null || num.length == 0) {
            return;
        }

        int end = num.length - 2;
        while (end >= 0 && num[end] >= num[end + 1]) {
            end--;
        }

        if (end == -1) {
            reverse(num, 0, num.length - 1);
            return;
        }

        int start = num.length - 1;
        while (start > end && num[start] <= num[end]) {
            start--;
        }
        swap(num, start, end);
        reverse(num, end + 1, num.length - 1);
    }

    private void swap(int[] num, int i, int j) {
        final int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }

    private void reverse(int[] num, int i, int j) {
        while (i < j) {
            swap(num, i++, j--);
        }
    }
}
