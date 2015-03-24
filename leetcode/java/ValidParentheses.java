import java.util.*;

public class ValidParentheses {
    /**
     * O(N)
     */
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        Stack<Character> stack = new Stack<Character>();
        for (char token : s.toCharArray()) {
            if (map.containsKey(token)) {
                stack.push(token);
            } else {
                if (stack.isEmpty() || map.get(stack.pop()) != token) {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }
    
    /**
     * O(kN)
     */
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        
        String left = "([{";
        String right = ")]}";
        Stack<Character> stack = new Stack<Character>();
        for (char token : s.toCharArray()) {
            if (left.indexOf(token) != -1) {
                stack.push(token);
            } else {
                if (stack.isEmpty() 
                    || left.indexOf(stack.pop()) != right.indexOf(token))
                {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }
}