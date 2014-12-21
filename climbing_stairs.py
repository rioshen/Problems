class Solution:
    # @param n, an integer
    # @return an integer
    def climbStairs(self, n):
        if n < 0:
            return 0
        prev, curr = 0, 1
        for i in xrange(n):
            prev, curr = curr, prev+curr
        return curr