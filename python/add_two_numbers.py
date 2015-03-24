class Solution:
    def addTwoNumbers(self, l1, l2):
        if not l1:
            return l2
        dummy = ListNode(-1)
        curr = dummy
        carry = 0
        while l1 or l2:
            res = carry
            res += l1.val if l1 else 0
            res += l2.val if l2 else 0

            carry = res / 10
            res = res % 10
            curr.next = ListNode(res)
            
            l1 = l1.next if l1 else None
            l2 = l2.next if l2 else None
            curr = curr.next
        curr.next = ListNode(carry) if carry else None
        return dummy.next