import java.util.*;

public class ThreeSumClosest {
    public int threeSumClosest(int[] num, int target) {
        if (num == null || num.length == 0) return 0;

        Arrays.sort(num);
        int closet = Integer.MAX_VALUE / 10;
        for (int i = 0; i < num.length; i++) {
            int j = i + 1;
            int k = num.length - 1;
            while (j < k) {
                int sum = num[i] + num[j] + num[k];
                if (sum == target) {
                    return target;
                } else if (sum < target) {
                    j++;
                } else {
                    k--;
                }

                if (Math.abs(closet - target) > Math.abs(sum - target)) {
                    closet = sum;
                }
            }
        }

        return closet;
    }
}
