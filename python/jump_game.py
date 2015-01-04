class Solution:
    # @param A, a list of integers
    # @return a boolean
    def canJump(self, A):
        max_so_far = 1 # represents the max index we can reach out
        i = 0
        while i < max_so_far and max_so_far < len(A):
            max_so_far = max(max_so_far, i+1+A[i])
            i += 1
        return max_so_far >= len(A)