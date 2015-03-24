#!/usr/bin/env python

class Solution:
    # @return a boolean
    def isValid(self, s):
        if not s:
            return True
        lft, rgt = '([{', ')]}'
        stack = []
        for token in s:
            if token in lft:
                stack.append(token)
            elif token in rgt:
                if not stack or lft.index(stack.pop()) != rgt.index(token):
                    return False
        return not stack
