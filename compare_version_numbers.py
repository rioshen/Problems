class Solution:
    # @param version1, a string
    # @param version2, a string
    # @return an integer
    def compareVersion(self, version1, version2):
        if not version1 or not version2:
            raise ValueError('wtf')

        v1, v2 = version1.split('.'), version2.split('.')
        common = max(len(v1), len(v2))

        for i in xrange(common):
            token1 = int(v1[i]) if i < len(v1) else 0
            token2 = int(v2[i]) if i < len(v2) else 0
            if token1 < token2:
                return -1
            elif token1 > token2:
                return 1
                
        return 0