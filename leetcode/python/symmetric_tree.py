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
    def isSymmetric(self, root):
        if not root:
            return True
        return self.symmetric(root.left, root.right)

    def symmetric(self, left, right):
        if not left and not right: # base case, hit the end
            return True

        if not left or not right: # subtrees have different depths
            return False
        if left.val != right.val: # subnodes' value aren't equal
            return False
        
        # recursively compare subtrees
        return self.symmetric(left.left, right.right) and \
            self.symmetric(left.right, right.left)

    def isSymmetric(self, root):
        '''Iteratly traverse the tree in preorder.'''
        if not root:
            return True
        stack = [root.left, root.right]
        while stack:
            rgt, lft = stack.pop(), stack.pop()
            if not lft and not rgt:
                continue
            if not lft or not rgt or lft.val != rgt.val:
                return False
            stack += [lft.left, rgt.right, lft.right, rgt.left]
        return True
