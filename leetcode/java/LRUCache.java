import java.util.LinkedHashMap;
import java.util.Map;
import java.util.HashMap;

/**
 * Created by Carl Shen on 2/3/15.
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

class LRUCache2 {
    private Node head;
    private Node tail;
    private Map<Integer, Node> map;
    private int capacity;

    static class Node {
        int value;
        int key;
        Node prev;
        Node next;

        public Node(int v, int k) {
            value = v;
            key = k;
        }
    }

    public LRUCache2(int capacity) {
        this.capacity = capacity;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<Integer, Node>();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);
        update(node);
        return node.value;
    }

    public void set(int key, int value) {
        if (map.containsKey(key)) {
            map.get(key).value = value;
            update(map.get(key));
        } else {
            if (map.size() == capacity) {
                removeLRUNode();
            }
            Node node = new Node(value, key);
            add2Tail(node);
            map.put(key, node);
        }
    }

    private void removeLRUNode() {
        Node node = head.next;
        head.next = node.next;
        node.next.prev = head;
        map.remove(node.key);
    }

    private void add2Tail(Node node) {
        tail.prev.next = node;
        node.prev = tail.prev;
        tail.prev = node;
        node.next = tail;
    }

    private void update(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;

        add2Tail(node);
    }
}
