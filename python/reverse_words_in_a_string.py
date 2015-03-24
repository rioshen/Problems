class Solution:
    # @param s, a string
    # @return a string
    def reverseWords(self, s):
        if not s:
            return ""
        else:
            return ' '.join(s.strip().split()[::-1])
    
    def reverseWords(self, s):
        if not s:
            return ""
        s = s.strip().split()

        lo, hi = 0, len(s)-1
        while lo <= hi:
            s[lo], s[hi] = s[hi], s[lo]
            lo, hi = lo+1, hi-1

        return ' '.join(s)