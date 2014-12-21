class Solution:
    def merge(self, A, m, B, n):
        i, j, k = m-1, n-1, m+n-1
        while i >= 0 and j >= 0:
            if A[i] > B[j]:
                A[k] = A[i]
                j -= 1
            else:
                A[k] = B[j]
                j -= 1
            k -= 1
        
        while j >= 0:
            A[k] = B[j]
            k, j = k-1, j-1