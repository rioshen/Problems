class Solution:
    # @return a string
    def longestPalindrome(self, s):
        if not s or len(s) < 2: # Null or single alpha
            return s

        # at least, palindromic substring is the first letter
        start = 0
        end = 1
        
        # to find the start and end position of a substring
        # we need to visit each center point then expand in
        # two direction
        center = 1
        while center < len(s):
            lft = center - 1
            rgt = center + 1
            
            # expand towards left
            while lft >= 0 and s[lft] == s[center]:
                lft -= 1
            while rgt < len(s) and s[rgt] == s[center]:
                rgt += 1
            center = rgt

            # it is a palindrome, expand in two directions
            while lft >= 0 and rgt < len(s) and s[lft] == s[rgt]:
                lft -= 1
                rgt += 1
            # calculate the length of palindromic substring

            length = rgt - lft - 1
            if end < length:
                start = lft + 1
                end = start+length

        return s[start:end]
        
if __name__ == '__main__':
    sol = Solution()
    print sol.longestPalindrome("abb")