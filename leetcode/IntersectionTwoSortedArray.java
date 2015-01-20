// Find the intersection of two sorted arrays.
// http://leetcode.com/2010/03/here-is-phone-screening-question-from.html
// A naive solution is to apply binary search to search if an element of A
// exist in B. To do this, we need to iterate through A and for each iteration
// do a binary search in B. The time complexity is O(m*logn).
// ============
// Because two arrays are sorted, if there's an intersection it means a same
// element appears in two arrays, we can use two indexes, which both start at zero
// Compare the first two elements in A and B, if A[0] is greater, we should move
// B's index, otherwise, if B[0] is greater, we move A's index. If they are equal
// we know an intersection has found, store it then increase A and B's index at
// the same time. The time complexity is O(m+n), for tthe worse case there are not
// intersectoins in A and B. The space complexity is O(1).

import java.util.*;

public class IntersectionTwoSortedArray {
    public List<Integer> intersection(int[] A, int[] B) {
        List<Integer> result = new LinkedList<Integer>();
        if (A == null || A.length == 0) {
            return result;
        } else if (B == null || B.length == 0) {
            return result;
        }
        
        int i = 0;
        int j = 0;
        while (i < A.length && j < B.length) {
            if (A[i] < B[j]) {
                i++;
            } else if (A[i] > B[j]) {
                j++;
            } else {
                result.add(A[i]);
                i++;
                j++;
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        int[] A = new int[]{1, 2, 3, 4, 5};
        int[] B = new int[]{3, 4, 5, 6, 7};
        IntersectionTwoSortedArray sol =  new IntersectionTwoSortedArray();
        System.out.println(sol.intersection(A, B));
    }
}