#!/usr/bin/env python

class Solution:
    def postorderTraversal(self, root):
        if not root:
            return []
        result, stack = [], []
        prev, curr = None, root
        while curr or stack:
            if curr:
                stack.append(curr)
                curr = curr.left
            else:
                parent = stack[-1]
                if parent not in (prev, None):
                    result.append(parent.val)
                    curr = parent.right
                else:

