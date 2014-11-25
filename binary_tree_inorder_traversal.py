#!/usr/bin/env python# Definition for a  binary tree node# class TreeNode:#     def __init__(self, x):#         self.val = x#         self.left = None#         self.right = Noneclass Solution:    # @param root, a tree node    # @return a list of lists of integers    def levelOrder(self, root):        if not root:            return [[]]        result, queue = [], collections.deque([root])        while queue:            sol = []            level = len(queue)            for i in xrange(level):                node = queue.popleft()                if node.left:                    queue.append(node.left)                if node.right:                    queue.append(node.right)                sol.append(node.val)            result.append(sol)        return result