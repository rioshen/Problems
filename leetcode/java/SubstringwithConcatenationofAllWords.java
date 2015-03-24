public class SubstringwithConcatenationofAllWords {
    public List<Integer> findSubstring(String S, String[] L) {
        List<Integer> res = new ArrayList<Integer>();
        if (S == null || L == null) return res;
        
        int total = L.length, wordLen = L[0].length();
        Map<String, Integer> table = new HashMap<String, Integer>();
        for (String word : L) {
            table.put(word, table.containsKey(word) ? table.get(word) + 1 : 1);
        }
        
        for (int i = 0; i <= S.length() - total * wordLen; i++) {
            Map<String, Integer> target = new HashMap<String, Integer>(table);
            for (int j = i; j <= S.length() -  wordLen && !target.isEmpty(); j += wordLen) {
                String s = S.substring(j, j + wordLen);
                if (!target.containsKey(s)) {
                    break;
                } else if (target.get(s) > 1) {
                    target.put(s, target.get(s) - 1);
                } else {
                    target.remove(s);
                }
            }
            if (target.size() == 0) {
                res.add(i);
            }
        }
        
        return res;
    }
}
