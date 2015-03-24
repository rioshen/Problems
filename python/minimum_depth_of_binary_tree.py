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
        else:
            return self.minHeight(root)
        
    def minHeight(self, node):
        if not node:
            return 1 << 31 - 1
        if not node.left and not node.right:
            return 1
        return min(self.minHeight(node.left), self.minHeight(node.right)) + 1