# Definition for a  binary tree node
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # @param root, a tree node
    # @return a list of integers
    def preorderTraversal(self, root):
        if not root:
            return []
        stack, result = [root], []
        while stack:
            node = stack.pop()
            if node.right:
                stack.append(node.right)
            if node.left:
                stack.append(node.left)
            result.append(node.val)
        return result

    def preorderTraversal(self, root):
        if not root:
            return []
        result = []
        result.append(root.val)
        result += self.preorderTraversal(root.left)
        result += self.preorderTraversal(root.right)
        return result