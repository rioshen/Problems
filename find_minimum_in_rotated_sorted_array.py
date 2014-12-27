class Solution:
    # @param num, a list of integer
    # @return an integer
    def findMin(self, num):
        if not num:
            return -1
        minimum = 1 << 32
        lo, hi = 0, len(num)-1
        while lo < hi and num[lo] > num[hi]:
            mid = (lo+hi) // 2
            if num[mid] < num[hi]:
                hi = mid
            else:
                lo = mid + 1
        return num[lo]