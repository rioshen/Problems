#!/usr/bin/env python

# Definition for a  binary tree node
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # @param root, a tree node
    # @return nothing, do it in place
    def flatten(self, root):
        if not root:
            return
        nodes = self.preorder(root)
        curr, nodes = nodes[0], nodes[1:]
        # deal with the root node
        curr.left = None
        for node in nodes:
            node.left = node.right = None
            curr.right = node
            curr = curr.right

    def preorder(self, root):
        if not root:
            return []
        result = []
        result.append(root)
        result += self.preorder(root.left)
        result += self.preorder(root.right)
        return result
