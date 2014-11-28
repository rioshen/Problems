#!/usr/bin/env python

# Definition for a  binary tree node
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # @param root, a tree node
    # @return an integer
    def minDepth(self, root):
        if not root:
            return 0
        return self.minHeight(root)

    def minHeight(self, root):
        if not root:
            return 2^31-1
        if not root.left and not root.right:
            return 1
        return min(self.minHeight(root.left), self.minHeight(root.right)) + 1
