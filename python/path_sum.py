#!/usr/bin/env python

# Definition for a  binary tree node
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # @param root, a tree node
    # @param sum, an integer
    # @return a boolean
    def hasPathSum(self, root, sum):
        if not root:
            return False

        # only check the result when we hit the leaf
        if not root.left and not root.right and root.val == sum:
            return True

        # otherwise, traverse the tree from left and right
        return self.hasPathSum(root.left, sum-root.val) or \
               self.hasPathSum(root.right, sum-root.val)
