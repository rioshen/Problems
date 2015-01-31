import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Robbert on 1/27/15.
 * 3Sum
 * https://oj.leetcode.com/problems/3sum/
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (num == null || num.length == 0) {
            return result;
        }

        Arrays.sort(num);
        for (int i = 0; i < num.length - 2; i++) {
            if (i - 1 >= 0 && num[i - 1] == num[i]) {
                continue;
            }
            int j = i + 1;
            int k = num.length - 1;
            while (j < k) {
                int sums = num[i] + num[j] + num[k];
                if (sums == 0) {
                    result.add(new LinkedList<Integer>(Arrays.asList(num[i], num[j], num[k])));
                    j++;
                    k--;
                    while (j < k && num[j] == num[j - 1]) {
                        j++;
                    }
                    while (j < k && num[k] == num[k + 1]) {
                        k--;
                    }
                } else if (sums < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }

        return result;
    }
}
