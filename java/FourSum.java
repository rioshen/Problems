import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Robbert on 1/31/15.
 * 4Sum
 * https://oj.leetcode.com/problems/4sum/
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (num == null || num.length == 0) {
            return result;
        }
        Arrays.sort(num);
        for (int i = 0; i < num.length - 3; i++) {
            if (i != 0 && num[i] == num[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < num.length - 2; j++) {
                if (j != i + 1 && num[j] == num[j - 1]) {
                    continue;
                }
                int lo = j + 1;
                int hi = num.length - 1;
                while (lo < hi) {
                    int sum = num[i] + num[j] + num[lo] + num[hi];
                    if (sum == target) {
                        result.add(new LinkedList<Integer>(Arrays.asList(num[i], num[j], num[lo], num[hi])));
                        lo++;
                        hi--;
                        while (lo < hi && num[lo] == num[lo - 1]) {
                            lo++;
                        }
                        while (lo < hi && num[hi] == num[hi + 1]) {
                            hi--;
                        }
                    } else if (sum < target) {
                        lo++;
                    } else {
                        hi--;
                    }
                }
            }
        }

        return result;
    }
}
