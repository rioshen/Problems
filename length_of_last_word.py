class Solution:
    # @param s, a string
    # @return an integer
    def lengthOfLastWord(self, s):
        if not s:
            return 0
        else:
            return len(s.strip().split(' ')[-1])
