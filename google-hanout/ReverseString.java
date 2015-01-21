// Reverse a String
// Iteration: Reverse the string by swapping the first character with the
// last character, the second character with the last-to-second character, and
// so on. 
// 
// Recursion: append the first character to the last, use call stac to hold that
// value until hit the end.
public class ReverseString {
    public String reverse(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }

        int index = 0;
        char[] content = str.toCharArray();
        for (int i = str.length() - 1; i >= str.length() / 2; i--) {
            char temp = content[index];
            content[index++] = content[i];
            content[i] = temp;
        }
        return new String(content);
    }

    public String reverseRecur(String str) {
        if (str == null || str.length() == 0) {
            return str;
        } else {
            return reverseRecur(str.substring(1)) + str.charAt(0);
        }
    }

    public String reverseWords(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }

        String[] content = str.split("\\s+");
        int left = 0;
        for (int right = content.length - 1; right >= content.length / 2; right--)
        {
            String temp = content[left];
            content[left++] = content[right];
            content[right] = temp;
        }
        
        StringBuilder sb = new StringBuilder();
        String prefix = "";
        for (String element : content) {
            sb.append(prefix);
            prefix = " ";
            sb.append(element);
        }
        
        return sb.toString();
    }

    public static void main(String[] args) {
        ReverseString sol = new ReverseString();
        System.out.println(sol.reverse("abc abc abc"));
        System.out.println(sol.reverseRecur("abc"));
        System.out.println(sol.reverseWords("Hello I am fine."));
    }
}