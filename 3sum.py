class Solution:
    # @return a list of lists of length 3, [[val1,val2,val3]]
    def threeSum(self, num):
        if not sum or len(sum) < 3:
            return []
        num.sort()
        result = set()
        for i in xrange(len(sum) - 2):
            lo, hi = i+1, len(sum)-1
            while lo < hi:
                triplet = (num[i], num[lo], num[hi])
                sums = sum(triplet)
                if sums == 0:
                    result.add(triplet)
                    lo, hi = lo+1, hi-1
                elif sums < 0:
                    lo += 1
                else:
                    hi -= 1
        return result

    def threeSum(self, num):
        if not num or len(num) < 3:
            return []
        num.sort()
        result = []
        for i in xrange(len(num)-2):
            if i-1 >= 0 and num[i-1] == num[i]:
                continue
            lo, hi = i+1, len(num)-1
            while lo < hi:
                triplet = [num[i], num[lo], num[hi]]
                sums = sum(triplet)
                if sums == 0:
                    result.append(triplet)
                    lo, hi = lo+1, hi-1
                    while lo < hi and num[lo] == num[lo-1]:
                        lo += 1
                    while lo < hi and num[hi] == num[hi+1]:
                        hi -= 1
                elif sums < 0:
                    lo += 1
                else:
                    hi -= 1
        return result
