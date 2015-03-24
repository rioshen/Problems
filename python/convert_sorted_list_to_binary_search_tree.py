# Definition for a  binary tree node
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
#
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def length(self, head):
        length = 0
        while head:
            head = head.next
            length += 1
         return length

    # @param head, a list node
    # @return a tree node
    def sortedListToBST(self, head):
        if not head:
            return None
        else:
            return self.buildTree(head, 0, self.length(head))

    def buildTree(self, node, start, end):
        if start > end or not node:
            return None
        mid = (start + end) // 2
        lft, node = self.buildTree(node, start, mid-1)
        root = TreeNode(node.val)
        node = node.next
        rgt, node = self.buildTree(node, mid+1, end)
        root.left = lft
        root.right = rgt
        
        return root, node