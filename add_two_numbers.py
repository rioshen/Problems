class Solution:
    # @return a ListNode
    def addTwoNumbers(self, l1, l2):
        """Returns the sum list represents the sum of two lists.

        Solution:
            Traverse both lists. One by one pick the nodes of both and add their
        values. If sum if more than ten then make carry as 1 and reduce the sum
        as the modular of sum divides by ten.
            If one list is larger than the other, we consider the remaining value
        of the list as 0, also while advancing both l1 and l2, if any of them is
        None keep it as None.

        Analysis:
            Time Complexity: O(M+N) where M and N are sizes of nodes in first
            and second lists respectively.
        """
        if not l1:
            return l2

        dummy = ListNode(-1)
        current = dummy
        carry = 0
        while l1 or l2:
            res = carry
            res += l1.val if l1 else 0
            res += l2.val if l2 else 0
            carry, res = res/10, res%10
            current.next = ListNode(res)

            current = current.next
            l1 = l1.next if l1 else None
            l2 = l2.next if l2 else None

        current.next = ListNode(carry) if carry > 0 else None
        return dummy.next
