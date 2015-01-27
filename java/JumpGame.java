/**
 * Created by Robbert on 1/27/15.
 * Jump Game
 * https://oj.leetcode.com/problems/jump-game/
 */
public class JumpGame {
    public boolean canJump(int[] A) {
        if (A == null || A.length == 0) {
            return false;
        }

        int maxJumpLength = 1;
        int i = 0;
        while (i < maxJumpLength && maxJumpLength < A.length) {
            maxJumpLength = Math.max(maxJumpLength, i + A[i] + 1);
            i++;
        }

        return maxJumpLength >= A.length;
    }
}
