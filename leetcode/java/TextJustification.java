import java.util.*;

/**
 * Created by Robbert on 2/11/15.
 * Text Justification
 * ["This", "is", "an", "example", "of", "text", "justification."], 16
 * https://oj.leetcode.com/problems/text-justification/
 */
public class TextJustification {
    public List<String> fullJustify(String[] words, int L) {
        List<String> res = new ArrayList<String>();
        if (words == null || words.length == 0) {
            return res;
        }
    
        int len = 0;
        String content = "";
        List<String> line = new ArrayList<String>();
        for (String word : words) {
            if (len + line.size() + word.length() <= L) {
                line.add(word);
                len += word.length(); // at least one space
            } else {
                if (line.size() == 1) { // single words in line
                    content = appendSpace(line.get(0), L);
                } else {
                    content = generateLine(line, L);
                }
                res.add(content);
                line.clear();
                line.add(word);
                len = word.length();
            }
        }
        
        content = line.get(0);
        for (int i = 1; i < line.size(); i++) {
            content += " " + line.get(i);
        }
        for (int j = L - content.length(); j > 0; j--) {
            content += " ";
        }
        res.add(content);
        
        return res;
    }
    
    private static String generateLine(List<String> line, int L) {
        int len = 0;
        for (String word : line) len += word.length();
        int spaceNumber = (L - len) / (line.size() - 1);
        int reminder = (L - len) % (line.size() - 1);
        String str = line.get(0);
        for (int i = 1; i < line.size(); i++) {
            for (int j = 0; j < spaceNumber; j++) {
                str += " ";
            }
            if (i <= reminder) {
                str += " ";
            }
            str += line.get(i);
        }
        return str;
    }
    
    private String appendSpace(String str, int L) {
        for (int i = L - str.length(); i > 0; i--) str += " ";
        return str;
    }
}
