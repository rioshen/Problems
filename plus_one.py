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
