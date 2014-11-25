#!/usr/bin/env python

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    # @param head, a ListNode
    # @return a list node
    def detectCycle(self, head):
        if not head:
            return None
        seen = set()
        current = head
        while current:
            if current.next in seen:
                return current.next
            seen.add(current.next)
            current = current.next
        return None
