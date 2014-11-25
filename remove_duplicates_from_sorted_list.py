# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    # @param head, a ListNode
    # @return a ListNode
    def deleteDuplicates(self, head):
        """Remove duplicates from the list such that each element appears
        only once.

        Solution:
            Traversing the list from the head node, while traversing compare
            each node with its next node. If value of next node is same then
            delete the next node.

        Analysis:
            Time Complexity: O(N) where N means the number of elements in the list
            Space Complexity: O(1)
        """
        if not head:
            return None
        curr = head
        while curr and curr.next:
            if curr.val == curr.next.val:
                curr.next = curr.next.next
            else:
                curr = curr.next
        return head
