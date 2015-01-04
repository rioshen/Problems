class Solution:
    # @param A, a list of integers
    # @param target, an integer to be searched
    # @return a list of length 2, [index1, index2]
    def searchRange(self, A, target):
        if not A:
            return [-1, -1]

        lft = -1
        lo, hi = 0, len(A)-1
        while lo <= hi:
            mid = (lo + hi) // 2
            if A[mid] == target:
                lft = mid
                hi = mid - 1
            elif A[mid] < target:
                lo = mid + 1
            else:
                hi = mid - 1

        rgt = -1
        lo, hi = 0, len(A)-1
        while lo <= hi:
            mid = (lo+hi) // 2
            if A[mid] == target:
                rgt = mid
                lo = mid + 1
            elif A[mid] < target:
                lo = mid + 1
            else:
                hi = mid - 1

        return [lft, rgt]
