#!/usr/bin/env python

# Definition for a  binary tree node
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # @param root, a tree node
    # @return a boolean
    def isValidBST(self, root):
        return self.valid(root, -9223372036854775807, 9223372036854775807)

    def valid(self, root, lo, hi):
        if not root:
            return True
        if root.val <= lo or root.val >= hi:
            return False
        return self.valid(root.left, lo, root.val) and self.valid(root.right, root.val, hi)
