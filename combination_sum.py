class Solution:
    # @param candidates, a list of integers
    # @param target, integer
    # @return a list of lists of integers
    def combinationSum(self, candidates, target):
        if not candidates:
            return []
        candidates.sort()
        result = []
        self.combination(candidates, target, [], result)
        return result

    def combination(self, seq, target, sol, res):
        if sum(sol) == target:
            res.append(sol)
            return
        for idx, val in enumerate(seq):
            sums = sum(sol) + val
            if sums > target:
                continue
            self.combination(seq[idx:], target, sol+[val], res)
