class Solution:
    # @return an integer
    def lengthOfLongestSubstring(self, s):
        if not s:
            return 0
        seen = set()
        length = 0
        lft = rgt = 0
        while rgt < len(s):
            if s[rgt] not in seen:
                seen.add(s[rgt])
            else:
                length = max(length, rgt-lft)
                while s[lft] != s[rgt]:
                    seen.remove(s[lft])
                    lft += 1
                lft += 1
            rgt += 1
        return max(length, rgt-lft)