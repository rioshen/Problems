public class SortColor {
    public void sortColors(int[] A) {
        if (A == null || A.length == 0) return;
        int r = 0, w = 0, b = A.length - 1;
        while (w <= b) {
            if (A[w] == 0) {
                swap(A, r, w);
                r++;
                w++;
            } else if (A[w] == 2) {
                swap(A, w, b);
                b--;
            } else {
                w++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
