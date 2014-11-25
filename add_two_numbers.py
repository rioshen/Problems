class Solution:
    # @return a ListNode
    def addTwoNumbers(self, l1, l2):
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
