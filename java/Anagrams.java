import java.util.*;

/**
 * Created by Robbert on 1/27/15.
 * Anagrams
 * https://oj.leetcode.com/problems/anagrams/
 */
public class Anagrams {
    public List<String> anagrams(String[] strs) {
        List<String> res = new LinkedList<String>();
        if (strs == null || strs.length == 0) {
            return res;
        }

        Map<String, List<String>> table = new HashMap<String, List<String>>();
        for (String str : strs) {
            String content = sort(str);
            if (!table.containsKey(content)) {
                table.put(content, new LinkedList<String>());
            }
            table.get(content).add(str);
        }

        for (String key : table.keySet()) {
            if (table.get(key).size() > 1) {
                res.addAll(table.get(key));
            }
        }

        return res;
    }

    private String sort(String str) {
        char[] content = str.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }
}
