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
            System.out.println(i + " " + maxJumpLength);
            i++;
        }


        return maxJumpLength >= A.length;
    }

    public static void main(String[] args) {
        JumpGame sol = new JumpGame();
        int[] test = new int[]{1, 0, 3, 4, 5};
        System.out.println(sol.canJump(test));
    }
}
