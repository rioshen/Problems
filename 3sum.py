class Solution:
    # @return a list of lists of length 3, [[val1,val2,val3]]
    def threeSum(self, num):
        """Returns all triplets that sum to zero.

        Solution:
            Sort the sequence at first.
            Fix the first element as *num[i]* where i is from 0 to len(num)-2.
            Traversing the sequence and intialize two indexes to find the
            candidate elements in the sorted array.

            It's like the finding process of binary search, loop while lft < rgt,
            1. If lft+rgt+num[i] == 0, append this triplet onto the result list,
               then increase the lft and decrease the right.
            2. If lft+rgt+num[i] < 0, we should increase the lft index
            3. Otherwise, decrease the rgt index

        Analysis:
            Time: O(N^2) where N means the size of the sequence.
            Space: O(1)
        """
        if not num or len(num) < 3:
            return []
        num.sort() # sort the sequence in-place
        result = []
        for i in xrange(len(num)):
            if i-1 >= 0 and num[i-1] == num[i]:
                continue
            lo, hi = i+1, len(num)-1
            while lo < hi:
                sol = [num[i], num[lo], num[hi]]
                sums = sum(sol)
                if sums == 0:
                    result.append(sol)
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

    def threeSumSet(self, num):
        """Returns a list of triplets sum to zero.

        Af the *num* may contain duplicates, we can use *set()* to filter
        duplicates, however, it will cause TLE error on LeetCode platform
        but it still worth to mention during the interview.
        """
        if not num or len(num) < 3:
            return []
        num.sort() # sort in-place, time O(nlogn)
        result = set()
        for i in xrange(len(num)-2):
            lo, hi = i+1, len(num)-1
            while lo < hi:
                sol = (num[i], num[lo], num[hi])
                sums = sum(sol)
                if sums == 0:
                    result.add(sol)
                    lo, hi = lo+1, hi-1
                elif sums < 0:
                    lo += 1
                else:
                    hi -= 1
        return result
