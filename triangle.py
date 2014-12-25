class Solution:

    # @param triangle, a list of lists of integers
    # @return an integer
    def minimumTotal(self, triangle):
        if not triangle:
            return 0

        length = len(triangle) + 1
        path = [[0] * length] * length

        for idx, val in enumerate(triangle[-1]):
            path[0][idx] = val

        for i in xrange(len(triangle)-1-1, -1, -1):
            for j, val in enumerate(triangle[i]):
                path[i][j] = min(path[i+1][j+1], path[i+1][j]) + val

        return path[0][0]