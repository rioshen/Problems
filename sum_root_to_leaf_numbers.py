#!/usr/bin/env python

# Definition for a binary tree node
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # @param root, a tree node
    # @return an integer
    def sumNumbers(self, root):
        return self.pathSum(root, 0)

    def pathSum(self, root, nums):
        if not root:
            return 0

        nums = nums*10 + root.val
        if not root.left and not root.right:
            return nums

        return self.pathSum(root.left, nums) + self.pathSum(root.right, nums)
