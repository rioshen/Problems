#!/usr/bin/env python

class Solution:
    def reverse(self, x):
        result = 0
        while x:
            result += result*10 + x%10
            x /= 10
        return result
