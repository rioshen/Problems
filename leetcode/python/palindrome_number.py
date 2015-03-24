#!/usr/bin/env python

class Solution:
    # @return a boolean
    def isPalindrome(self, x):
        if x < 0: # negative number couldn't be a palindrome
            return False

        # find the step to visit the high end
        div = 1
        while x/div >= 10:
            div *= 10

        while x:
            lo = x % 10
            hi = x / div
            if lo != hi:
                return False
            x = x%div / 10
            div /= 100

        return True
