import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Robbert on 2/3/15.
 * LRUCache
 * https://oj.leetcode.com/problems/lru-cache/
 */
public class LRUCache {
    LinkedHashMap<Integer, Integer> map;
    int capacity;

    public LRUCache(final int capacity) {
        // create a map.
        map = new LinkedHashMap<Integer, Integer>(capacity) {
            private static final long serialVersionUID = 1L;

            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > capacity;
            }
        };
        this.capacity = capacity;
    }

    public int get(int key) {
        Integer ret = map.get(key);
        if (ret == null) {
            return -1;
        } else {
            map.remove(key);
            map.put(key, ret);
        }

        return ret;
    }

    public void set(int key, int value) {
        map.remove(key);
        map.put(key, value);
    }
}
