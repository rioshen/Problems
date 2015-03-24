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
        if not root: # empty tree is balanced tree
            return True
        else:
            return self.getHeight(root) != -1
    
    def getHeight(self, node):
        '''Return -1 if any subtrees of current node is unbalanced, otherwise
        returns the maximum height of subtrees.'''
        if not node: # base case, visiting a leaf
            return 0
        
        # check left subtree, if it's unbalanced, prune the path
        # we don't need to recursively check the right subtree
        left = self.getHeight(node.left)
        if left == -1: 
            return -1
            
        # check right subtree, same like left subtree
        right = self.getHeight(node.right)
        if right == -1:
            return -1
            
        # over the definition of balanced tree
        if abs(left - right) > 1:
            return -1
            
        return max(left, right) + 1