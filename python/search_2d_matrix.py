#!/usr/bin/env python

class Solution:
    def searchMatrix(self, matrix, target):
        if not matrix:
            return False
        rows, cols = len(matrix), len(matrix[0])
        lo, hi = 0, rows*cols-1
        while lo <= hi:
            mid = (lo + hi) // 2
            val = matrix[mid / cols][mid % cols]
            if val == target:
                return True
            elif val < target:
                lo = mid + 1
            else:
                hi = mid - 1
        return False
