class Solution:
    # @param s, a string
    # @return a list of lists of string
    def partition(self, s):
        if not s:
            return []
        result = []
        s.sort()
        self.getPartition(s, [], result)
        return result

    def getPartition(self, seq, sol, res):
        if not seq:
            res.append(sol)
            return
            
        for i in xrange(len(seq)):
            if self.palindrome(seq[:i+1]):
                self.getPartition(seq[i+1:], sol+[seq[:i+1]], res)

    def palindrome(self, seq):
        return seq == seq[::-1]