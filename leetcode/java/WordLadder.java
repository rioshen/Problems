import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by Robbert on 2/2/15.
 * Word Ladder
 * https://oj.leetcode.com/problems/word-ladder/
 */
public class WordLadder {
    public int ladderLength(String start, String end, Set<String> dict) {
        if (dict == null || dict.size() == 0) return 0;

        Queue<String> queue = new LinkedList<String>();
        queue.offer(start);
        dict.remove(start);
        int len = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                for (int j = 0; j < current.length(); j++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == current.charAt(j)) continue;
                        String temp = constructWord(current.toCharArray(), j, c);
                        if (temp.equals(end)) {
                            return len + 1;
                        }
                        if (dict.contains(temp)) {
                            queue.offer(temp);
                            dict.remove(temp);
                        }
                    }
                }
            }
            len++;
        }

        return 0;
    }

    private String constructWord(char[] content, int pos, char ch) {
        content[pos] = ch;
        return new String(content);
    }
}
