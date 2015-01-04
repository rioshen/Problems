class Solution:
    def strStr(self, haystack, needle):
        for i in xrange(len(haystack)-len(needle)+1):
            if haystack[i: i+len(needle)] == needle:
                return i
        return -1