class Solution:
    # @return a list of lists of integers
    def generate(self, numRows):
        if numRows < 0:
            return []
        result = []
        
        # initialize the first row in the triangle
        row = [1]
        
        # for the rest rows of the triangle, we use a padding to make sure
        # each row have the same columns
        padding = [0]
        
        # each new generated row follows the same rule:
        #   1 [0] 
        # + 0 [1]
        # = 1 1
        for i in xrange(numRows):
            result.append(row)
            row = [prev + curr for prev, curr in zip(row+padding, padding+row)]
        return result