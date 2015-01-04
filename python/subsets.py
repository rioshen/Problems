class Solution:
    # @param S, a list of integer
    # @return a list of lists of integer
    def subsets(self, S):
        if not S:
            return []
        S.sort()
        result = []
        self.subset(S, [], result)
        return result

    def subset(self, seq, sol, res):
        res.append(sol)
        for idx, val in enumerate(seq):
            self.subset(seq[idx+1:], sol+[val], res)
