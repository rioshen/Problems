class Solution:
    # @param matrix, a list of lists of integers
    # @return a list of lists of integers
    def rotate(self, matrix):
        if not matrix:
            raise ValueError('wtf')

        rows, cols = len(matrix), len(matrix[0])
        result = [[0 for _ in range(cols)] for _ in range(rows)]
        for r in xrange(rows):
            for c in xrange(cols):
                result[c][rows-r-1] = matrix[r][c]
        return result
