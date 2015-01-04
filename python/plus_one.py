#!/usr/bin/env python

class Solution:
    def plusOne(self, digits):
        if not digits:
            return []
        result = []
        carry = 1
        for idx, val in enumerate(reversed(digits)):
            # plus one in reversed order
            res = carry + val
            carry, res = res / 10, res % 10
            result.append(res)
        # deal with the msb carry
        if carry:
            result.append(carry)
        return result[::-1]
        
    def plusOne(self, digits):
        if not digits:
            return []
        result = []
        carry = 1
        for i in xrange(len(digits)-1, -1, -1):
            res = carry + digits[i]
            carry = res / 10
            res = res % 10
            result.append(res)
        if carry:
            result.append(carry)
        return result[::-1]