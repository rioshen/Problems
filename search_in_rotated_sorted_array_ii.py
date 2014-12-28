class Solution:
    # @param A a list of integers
    # @param target an integer
    # @return a boolean
    def search(self, A, target):
        if not A:
            return False
        lo, hi = 0, len(A)-1
        while lo <= hi:
            mid = (lo+hi) // 2
            midval = A[mid]
            if midval == target:
                return True
            elif A[lo] < midval:
                if A[lo] <= target < midval:
                    hi = mid
                else:
                    lo = mid + 1
            elif A[lo] > midval:
                if midval < target <= A[hi]:
                    lo = mid + 1
                else:
                    hi = mid
            else:
                lo += 1
        return False

    def search(self, A, target):
        if not A:
            raise ValueError('wtf')
        for elem in A:
            if elem == target:
                return True
        return False