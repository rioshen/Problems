/**
 * Created by Carl Shen on 1/27/15.
 * Jump Game
 * https://oj.leetcode.com/problems/jump-game/
 */
public class JumpGame {
    public boolean canJump(int[] A) {
        if (A == null || A.length == 0) {
            return false;
        }

        int maxStep = 0;
        for (int i = 0; i < A.length; i++) {
            if (maxStep >= i) {
                maxStep = Math.max(maxStep, A[i] + i);
            }
        }

        return maxStep >= (A.length - 1);
   }
}
