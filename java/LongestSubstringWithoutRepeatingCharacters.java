import java.util.HashSet;
import java.util.Set;

/**
 * Created by Robbert on 1/4/15.
 */
public class LongestSubstringWithoutRepeatingCharacters {
     public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            throw new IllegalArgumentException();
        }

        int length = 0;
        int start = 0;
        int end = 0;
        Set<Character> seen = new HashSet<Character>();
        while (end < s.length()) {
            char content = s.charAt(end);
            if (!seen.add(content)) { // we've visited this character
                length = Math.max(length, end - start);
                while (s.charAt(start) != content) {
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
