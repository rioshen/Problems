#!/usr/bin/env python

class Solution:
    def reverse(self, x):
        sign = 1
        if not x: # negative number
            sign, x = -1, abs(x)

        result = 0
        while x:
            result = result*10 + x%10
            x /= 10

        # for a 32 bits integer, the max value is (2^31 - 1)
        if result >= (2**31 - 1):
            return 0

        return sign*result
