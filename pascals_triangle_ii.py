class Solution:
    # @return a list of integers
    def getRow(self, rowIndex):
        if rowIndex < 0: return []
        result = []
        row = [1]
        padding = [0]
        for i in xrange(rowIndex):
            row = [prev+curr for prev, curr in zip(row+padding, padding+row)]
        return row