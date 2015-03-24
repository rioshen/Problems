#!/usr/bin/env python

# Definition for a  binary tree node
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # @param root, a tree node
    # @return a list of lists of integers
    def zigzagLevelOrder(self, root):
        if not root:
            return []
        l2r = True
        result, queue = [], collections.deque([root])
        while queue:
            level, size = [], len(queue)
            for i in xrange(size):
                node = queue.popleft()
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
                level.append(node.val)
            if l2r:
                result.append(level)
            else:
                result.append(level[::-1])
            l2r = not l2r
        return result
