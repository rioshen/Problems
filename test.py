class Solution:
    # @return an integer
    def threeSumClosest(self, num, target):
        if not num:
            return []
        num.sort()
        closest = 1 << 32
        for i in xrange(len(num)-2):
            lo, hi = i+1, len(num)-1
            while lo < hi:
                sums = num[i] + num[lo] + num[hi]
                if sums == target:
                    return sums
                elif sums < target:
                    lo += 1
                else:
                    hi -= 1
                if abs(sums-target) < abs(closest-target):
                    closest = sums
        return closest


if __name__ == '__main__':
    sol = Solution()
    print sol.threeSumClosest([1,1,1,0], 100)
