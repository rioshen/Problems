#!/usr/bin/env python

class Solution:
    # @return a string
    def longestCommonPrefix(self, strs):
        if not strs:
            return ''

        # find the minimum and maximum string in the sequence
        # this is the easist way to find the LCS
        str1 = min(strs)
        str2 = max(strs)

        # iterate over the minimum string and compare the value with
        # the maximum string, once we find a difference, slice the max
        # stop at the current position
        for idx, val in enumerate(str1):
            if val != str2[idx]:
                return str1[:idx]
        return str1
