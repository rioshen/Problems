import java.util.*;

/**
 * Created by Robbert on 1/27/15.
 * Anagrams
 * https://oj.leetcode.com/problems/anagrams/
 */
public class Anagrams {
    private String sortHelper(String str) {
        char[] content = str.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }

    public List<String> anagrams(String[] strs) {
        List<String> result = new LinkedList<String>();
        if (strs == null || strs.length == 0) {
            return result;
        }

        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            String key = sortHelper(str);
            if (!map.containsKey(key)) {
                map.put(key, new LinkedList<String>());
            }
            map.get(key).add(str);
        }

        for (String key : map.keySet()) {
            if (map.get(key).size() > 1) {
                result.addAll(map.get(key));
            }
        }

        return result;
    }
}
