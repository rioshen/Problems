#!/usr/bin/env python

class Solution:
    def anagrams(self, strs):
        if not strs:
            return []
        table = {}
        for elem in strs:
            key = ''.join(sorted(elem))
            table[key] = table.get(key, []) + [elem]
        result = []
        for val in table.values():
            if len(val) > 1:
                result += val
        return result
