class Solution:
    # @param s, a string
    # @return a boolean
    def isPalindrome(self, s):
        if not s:
            return True

        # trim spaces
        s = s.strip() 
        if not s: return True

        lo, hi = 0, len(s)-1
        while lo <= hi:
            if not s[lo].isalnum():
                lo += 1
            elif not s[hi].isalnum():
                hi-= 1
            elif s[lo].lower() != s[hi].lower():
                return False
            else:
                lo += 1
                hi -= 1

        return True