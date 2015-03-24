/**
 * Created by Robbert on 1/26/15.
 * Find Peak Element
 * https://oj.leetcode.com/problems/find-peak-element/
 */
public class FindPeakElement {
    public int findPeakElementLinear(int[] num) {
        for (int i = 1; i < num.length - 1; i++) {
            if (num[i - 1] > num[i]) return i - 1;
        }
        return num.length - 1;
    }
    
    public int findPeakElement(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }

        int lo = 0;
        int hi = num.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (mid != 0 && num[mid] < num[mid - 1]) {
                hi = mid;
            } else if (mid != num.length - 1 && num[mid] < num[mid + 1]) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
}
