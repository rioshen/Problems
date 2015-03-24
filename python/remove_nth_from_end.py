#!/usr/bin/env python

class Solution:
    def removeNthFromEnd(self, head, n):
        if not head:
            return None
        dummy = ListNode(-1)
        dummy.next = head
        fast = slow = dummy
        while n:
            fast = fast.next
            n -= 1
        while fast and fast.next:
            slow = slow.next
            fast = fast.next
        slow.next = slow.next.next
        return dummy.next
