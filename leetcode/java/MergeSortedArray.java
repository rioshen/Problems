public class MergeSortedArray {
    public void merge(int A[], int m, int B[], int n) {
        if (A == null || B == null) return;
        int i = m - 1;
        int j = n - 1;
        int last = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (A[i] > B[j]) {
                A[last--] = A[i--];
            } else {
                A[last--] = B[j--];
            }
        }
        while (j >= 0) {
            A[last--] = B[j--];
        }
    }
}