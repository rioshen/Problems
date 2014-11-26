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
    def isBalanced(self, root):
        """按照定义判断树是否平衡的标准方式。但是递归调用的次数过多，
        会造成超时。"""
        if not root:
            return True
        lft, rgt = self.getHeight(root.left), self.getHeight(root.right)
        if abs(lft - rgt) <= 1 or self.isBalanced(root.left) or \
            self.isBalanced(root.right):
            return True
        return False

    def getHeight(self, root):
        if not root:
            return 0
        return max(self.getHeight(root.left), self.getHeight(root.right)) + 1

    def isBalanced(self, root):
        if not root:
            return True
        return self.getHeight(root) != -1

    def getHeight(self, root):
        if not root:
            return 0
        left = self.getHeight(root.left)
        if left == -1:
            return -1
        right = self.getHeight(root.right)
        if right == -1:
            return -1
        if abs(left - right) > 1:
            return -1
        return max(left, right) + 1
