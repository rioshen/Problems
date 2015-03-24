import java.util.HashSet;
import java.util.Set;

/**
 * Created by Robbert on 1/4/15.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        
        int start = 0, end = 0;
        int length = 0;
        Set<Character> seen = new HashSet<Character>();
        while (end < s.length()) {
            char c = s.charAt(end);
            if (!seen.add(c)) {
                length = Math.max(length, end - start);
                while (s.charAt(start) != c) {
                    seen.remove(s.charAt(start));
                    start++;
                }
                start++;
            }
            end++;
        }
        
        return Math.max(length, end - start);
    }
}
