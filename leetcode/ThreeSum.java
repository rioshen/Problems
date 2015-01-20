// Finding all unique triplets that sums to zero
// http://leetcode.com/2010/04/finding-all-unique-triplets-that-sums.html
// For a two sum problem, if the input array is sorted, we can use two indexes
// first and last, each pointing to the first and last element, we look at the
// element pointed by first, let's call it A. Our target is to find B which equals
// to K - A. So if the element pointed by last is less than B, we know that the
// choice is to increase pointer first by one step.
// Similar, if the element pointed by last is greater than B, we descrease pointer
// last by one step.
//
// For a three sum, we can also apply this approach with an outer loop. The time
// complexity is O(n ^ 2).

import java.util.*;

public class ThreeSum {
    public Set<List<Integer>> threeSum(List<Integer> nums, int target) {
        Set<List<Integer>> result = new HashSet<List<Integer>>();
        if (nums == null || nums.size() == 0) {
            return result;
        }
        
        // sort the array
        Collections.sort(nums);

        for (int i = 0; i < nums.size(); i++) {
            int lo = i + 1;
            int hi = nums.size() - 1;
            while (lo <= hi) {
                int sum = nums.get(i) + nums.get(lo) + nums.get(hi);
                if (sum == target) {
                    result.add(new ArrayList<Integer>(Arrays.asList(
                               nums.get(i),
                               nums.get(lo),
                               nums.get(hi))));
                    lo++;
                    hi--;
                } else if (sum < target) {
                    lo++;
                } else {
                    hi--;
                }
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
        ThreeSum sol = new ThreeSum();
        System.out.println(sol.threeSum(nums, 6));
    }
}