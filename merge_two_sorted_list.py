class Solution:
    # @param two ListNodes
    # @return a ListNode
    def mergeTwoLists(self, l1, l2):
        """Merges two sorted list into one and returns the new head node.

        Solution:
            The general idea is merge sort, especially partition operation.
            Traverse two sorted lists and compare their value, append the
            smaller one onto the end of the result list.

            We use a temporary dummy node as the head of the result list, and
            a pointer *current* always points to the last node in the result
            list.

        Analysis:
            Time Complexity: O(min(N, M)) where N and M means two lists
            respectively.

            Space Complexity: O(N+M)
        """
        if not l1:
            return l2
        dummy = ListNode(-1)
        current = dummy
        while l1 and l2:
            if l1.val < l2.val:
                current.next = l1
                l1 = l1.next
            else:
                current.next = l2
                l2 = l2.next
            current = current.next
        current.next = l1 if l1 else l2
        return dummy.next
