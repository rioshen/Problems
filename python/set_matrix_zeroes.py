class Solution:
    # @param matrix, a list of lists of integers
    # RETURN NOTHING, MODIFY matrix IN PLACE.
    def setZeroes(self, matrix):
        lineNum = len(matrix); colNum = len(matrix[0])
        lineToZeros = set(); colToZeros = set()
        for i in xrange(lineNum):
            for j in xrange(colNum):
                if matrix[i][j] == 0:
                    lineToZeros.add(i)
                    colToZeros.add(j)

        for i in lineToZeros:
            for j in xrange(colNum):
                matrix[i][j] = 0

        for j in colToZeros:
            for i in xrange(lineNum):
                matrix[i][j] = 0
