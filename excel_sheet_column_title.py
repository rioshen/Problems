class Solution:
    # @return a string
    def convertToTitle(self, num):
        answer = ''
        while num:
            answer = chr(ord('A') + (num-1)%26) + answer
            num = (num-1) / 26
        return answer