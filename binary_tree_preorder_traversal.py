#!/usr/bin/env python

class Solution:
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
        result.extend(self.preorderTraversal(root.left))
        result.extend(self.preorderTraversal(root.right))
        return result
