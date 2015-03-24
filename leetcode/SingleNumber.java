public class SingleNumber {
    public int singleNumberTLE(int[] A) {
        if (A == null || A.length == 0) {
            throw new IllegalArgumentException();
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int elem : A) {
            map.put(elem, map.containsKey(elem) ? map.get(elem) + 1 : 1);
        }
        for (int key : map.keySet()) {
            if (map.get(key) == 1) return key;
        }
        throw new IllegalArgumentException();
    }
    
    public int singleNumber(int[] A) {
        int res = 0;
        for (int elem : A) res ^= elem;
        return res;
    }
}