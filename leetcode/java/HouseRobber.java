public class HouseRobber {
    public int rob(int[] num) {
        if (num == null || num.length < 1) {
            return 0;
        }
        int a = 0, b = 0;
        for (int i = 0; i < num.length; i++) {
            if (i % 2 == 0) {
                a = Math.max(a + num[i], b);
            } else {
                b = Math.max(b + num[i], a);
            }
        }
        return Math.max(a, b);
    }
}