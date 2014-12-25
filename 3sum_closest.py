class Solution:
    # @return an integer
    def threeSumClosest(self, num, target):
        if not num or len(num) < 3:
            return []
        num.sort()
        closest = 1 << 32
        for i in xrange(len(num)-1):
            lo, hi = i+1, len(num)-1
            while lo < hi:
                sums = num[i] + num[lo] + num[hi]
                if sums == target:
                    return sums
                elif sums < target:
                    lo += 1
                else:
                    hi -= 1
                # compare which one is the closest to the target
                if abs(sums-target) < abs(closest-target):
                    closest = sums
        return closest