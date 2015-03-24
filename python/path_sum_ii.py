# Definition for a  binary tree node
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # @param root, a tree node
    # @param sum, an integer
    # @return a list of lists of integers
    def pathSum(self, root, sum):
        if not root:
            return []
        result = []
        self.pathFinder(root, sum, [], result)
        return result

    def pathFinder(self, root, num, sol, res):
        if not root:
            return

        if not root.left and not root.right and root.val == num:
            sol.append(root.val)
            res.append(sol)
            return

        self.pathFinder(root.left, num-root.val, sol+[root.val], res)
        self.pathFinder(root.right, num-root.val, sol+[root.val], res)
