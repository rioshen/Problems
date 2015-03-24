import java.util.*;

public class SimplifyPath {
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) return "";

        Stack<String> stack = new Stack<String>();
        for (String elem : path.split("/")) {
            if (elem.equals(".") || elem.length() == 0) {
                continue;
            } else if (elem.equals("..")){
                if (!stack.isEmpty()) stack.pop();
            } else {
                stack.push(elem);
            }
        }
        if (stack.isEmpty()) {
            return "/";
        }

        StringBuilder sb = new StringBuilder();
        for (String elem : stack) sb.append("/").append(elem);
        return sb.toString();
    }
}
