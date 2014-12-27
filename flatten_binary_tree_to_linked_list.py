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

    def flatten(self, root):
        if not root: return # base case
        
        self.flatten(root.left)
        self.flatten(root.right)
        
        if not root.left: return
        
        lft = root.left
        while lft.right:
            lft = root.right
        lft.right = root.left
        root.left = None
        
    def flatten(self, root):
        if not root:
            return
        
        stack = [root]
        while stack:
            node = stack.pop()
            if node.right:
                stack.append(node.right)
            if node.left:
                stack.append(node.left)
            
            node.left = None
            if stack: node.right = stack[-1]