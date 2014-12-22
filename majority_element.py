class Solution:
    # @param num, a list of integers
    # @return an integer
    def majorityElement(self, num):
        count, majority = 1, num[0]
        for elem in num[1:]:
            if majority != elem:
                count -= 1
            else:
                count += 1
            if count < 0:
                majority = elem
                count = 0
        return majority