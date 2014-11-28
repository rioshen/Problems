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
        return self.minHeight(root, 0)

    def minHeight(self, root, depth):
        if not root:
            return depth

        if root.left and not root.right:
            return self.minHeight(root.left, depth+1)
        elif not root.left and root.right:
            return self.minHeight(root.right, depth+1)
        else:
            return min(self.minHeight(root.left, depth+1),
                       self.minHeight(root.right, depth+1))
