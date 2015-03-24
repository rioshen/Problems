#!/usr/bin/env python

class Solution:
    # @return a string
    def minWindow(self, S, T):
        if not S or not T:
            return ""
        seen, target = {}, set(T)
        lft, rgt = 0, len(S)-1
