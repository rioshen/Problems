#!/usr/bin/env python

class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = self.right = None

class Solution:
    def isSameTree(self, p, q):
        """Recursion"""
        if not p and not q:
            return True
        if not p or not q:
            return False
        if p.val != q.val:
            return False
        return self.isSameTree(p.left, q.left) and \
            self.isSameTree(p.right, q.right)

    def isSameTree(self, p, q):
        """Iteration"""
        if not p and not q:
            return True
        stack = [p, q]
        while stack:
            rgt, lft = stack.pop(), stack.pop()
            if not lft and not rgt:
                continue
            if not lft or not rgt:
                return False
            if lft.val != rgt.val:
                return False
            stack += [lft.left, rgt.left, lft.right, rgt.right]
        return True
