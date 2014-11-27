#!/usr/bin/env python

class Solution:
    # @param a, a string
    # @param b, a string
    # @return a string
    def addBinary(self, a, b):
        if not a:
            return b
        commlen = max(len(a), len(b))
        a, b = a.zfill(commlen), b.zfill(commlen)
        result, carry = [], 0
        for i in xrange(commlen-1, -1, -1):
            res = carry + int(a[i]) + int(b[i])
            carry, res = res / 2, res % 2
            result.append(str(res))
        if carry:
            result.append(str(carry))
        return ''.join(reversed(result))
