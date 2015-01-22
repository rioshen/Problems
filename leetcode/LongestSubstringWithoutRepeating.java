// Longest Substring Without Repeating Characters
// http://leetcode.com/2011/05/longest-substring-without-repeating-characters.html
// Solution
// A brute force approach is simple, enumerate all possible substring and filter
// out those with repeating characters. This can be done using nested loops.
// To do it better, we can use a Set to store each characters and when we found 
// a repeated character, let's say at the position j, it means j - 1 could be
// a possible longest substring, because of this, we need to update the longest
// length. Besides, it also means the repeated characters must have appeared
// before, let's say, at index i where i is less than j. In order to take the 
// consecutive substring, we need to remove all characters before i and start
// looking new one at the index i+1
// So we need to indices to record the head and the tail of the current substring
// Time complexity: O(N), where N is the length of string
// Space: O(N), for worst case, string only contains unique characters.

import java.util.*;

public class LongestSubstringWithoutRepeating {
    public int longestSubstring(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        
        int i = 0;
        int j = 0;
        int maxLength = 0;
        Set<Character> set = new HashSet<Character>();
        while (j < str.length()) {
            char ch = str.charAt(j);
            if (!set.contains(ch)) {
                set.add(ch);
            } else {
                maxLength = Math.max(maxLength, j - i);
                char repeated = str.charAt(i);
                while (repeated != ch) {
                    set.remove(repeated);
                    i++;
                }
                i++;
            }
            j++;
        }
        
        return Math.max(maxLength, j - i);
    }
    
    public static void main(String[] args) {
        LongestSubstringWithoutRepeating sol = new LongestSubstringWithoutRepeating();
        System.out.println(sol.longestSubstring("abcdabc"));
    }
}