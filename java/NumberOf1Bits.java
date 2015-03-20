public class NumberOf1Bits {
    public int hammingWeight(int n) {
        int cnt = 0;
        for (cnt = 0; n != 0; cnt++) {
            n = n & (n - 1);
        }
        return cnt;
    }
}
