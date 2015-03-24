class Solution:
    # @param A, a list of integers
    # @param target, an integer to be searched
    # @return an integer
    def search(self, A, target):
        if not A:
            return -1
        lo, hi = 0, len(A)-1
        while lo <= hi:
            mid = (lo+hi) // 2
            midval = A[mid]
            if midval == target:
                return mid
            elif A[lo] <= midval:
                # the bottom half is sorted
                if A[lo] <= target < midval:
                    hi = mid - 1
                else:
                    lo = mid + 1
            else:
                if midval < target <= A[hi]:
                    lo = mid + 1
                else:
                    hi = mid - 1
        return -1