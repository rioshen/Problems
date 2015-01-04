#!/usr/bin/env python

class Solution:
    def twoSum(self, num, target):
        if not num:
            return [-1, -1]
        table = {}
        for idx, val in enumerate(num):
            if val not in table:
                table[target-val] = idx
            else:
                return [min(table[val]+1, idx+1),
                        max(table[val]+1, idx+1)]
        return [-1, -1]
