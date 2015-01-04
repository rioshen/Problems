class Solution:
    def removeDuplicates(self, A):
        if not A:
            return 0
        idx = 1
        for i in xrange(1, len(A)):
            if A[idx-1] != A[i]:
                A[idx] = A[i]
                idx += 1
        return idx