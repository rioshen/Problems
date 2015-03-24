# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    # @param head, a ListNode
    # @return nothing
    def reorderList(self, head):
        if not head:
            return
        # in order to reverse the second half, we need to find
        # the last element of the first half and set it to None
        tail = self.findMiddle(head)
        second = self.reverse(tail.next)
        
        # cut the first half
        tail.next = None
        
        self.merge(head, second)
        
    def findMiddle(self, node):
        slow = fast = node
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        return slow
        
    def reverse(self, head):
        prev = None
        curr = head
        while curr:
            next = curr.next
            curr.next = prev
            prev = curr
            curr = next
        return prev
        
    def merge(self, l1, l2):
        if not l1:
            return l2
        curr = ListNode(-1)
        counter = 0
        while l1 and l2:
            if counter % 2 == 0:
                curr.next = l1
                l1 = l1.next
            else:
                curr.next = l2
                l2 = l2.next
            curr = curr.next
            counter += 1
            
        curr.next = l1 if l1 else l2