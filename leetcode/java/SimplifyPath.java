import java.util.*;

public class SimplifyPath {
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) {
            return "";
        }

        String[] content = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String dir : content) {
            if (dir.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (dir.equals(".") || dir.length() == 0) {
                continue;
            } else {
                stack.push(dir);
            }
        }

        // if stack is empty, it means we are at root
        if (stack.isEmpty()) {
            return "/";
        }
        
        StringBuilder result = new StringBuilder();
        for (String dir : stack) {
            result.append("/").append(dir);
        }
        return result.toString();
    }
    
    public static void main(String[] args) {
        SimplifyPath sol = new SimplifyPath();
        System.out.println(sol.simplifyPath("/../"));
        System.out.println(sol.simplifyPath("/home//foo/"));
        System.out.println(sol.simplifyPath("/a/./b/../../c/"));
    }
}
