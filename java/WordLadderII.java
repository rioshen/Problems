import java.util.*;

/**
 * Created by terry on 1/4/15.
 */
public class WordLadderII {
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        if (start == null || end == null || dict == null) {
            throw new IllegalArgumentException();
        }

        // construct the graph based on the given dictionary
        Map<String, ArrayList<String>> graph = new HashMap<String, ArrayList<String>>();
        dict.add(start);
        dict.add(end);
        for (String word : dict) {
            graph.put(word, new ArrayList<String>());
        }
        for (String word : dict) {
            for (int i = 0; i < word.length(); i++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    if (c != word.charAt(i)) {
                        String expanded = word.substring(0, i) + c + word.substring(i + 1);
                        if (dict.contains(expanded)) {
                            graph.get(word).add(expanded);
                        }
                    }
                }
            }
        }

        // do a bfs search
        List<List<String>> result = new LinkedList<List<String>>();
        Queue<String> queue = new LinkedList<String>();
        queue.add(start);
        while (!queue.isEmpty()) {
            String current = queue.poll();
            List<String> path = new LinkedList<String>();

        }


        return null;
    }

    public static void main(String[] args) {
        Set<String> set = new HashSet<String>();
        set.add("dot");
        set.add("hot");
        set.add("dog");
        set.add("lot");
        set.add("log");
        new WordLadderII().findLadders("null", "null", set);
    }
}
