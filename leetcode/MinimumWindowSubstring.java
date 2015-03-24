public class MinimumWindowSubstring {
    public String minWindow(String S, String T) {
        if (S == null || S.length() == 0 || S.length() < T.length()) {
            return "";
        }

        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (char c : T.toCharArray()) {
            map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1);
        }

        int l = 0;
        int count = 0;
        int len = Integer.MAX_VALUE;
        int start = 0;
        for (int r = 0; r < S.length(); r++) {
            char c = S.charAt(r);
            if (!map.containsKey(c)) {
                continue;
            }

            map.put(c, map.get(c) - 1);
            if (map.get(c) >= 0) {
                count++;
            }

            while (count == T.length()) {
                if (r - l + 1 < len) {
                    len = r - l + 1;
                    start = l;
                }
                if (map.containsKey(S.charAt(l))) {
                    char ch = S.charAt(l);
                    map.put(ch, map.get(ch) + 1);
                    if (map.get(ch) > 0) {
                        count--;
                    }
                }
                l++;
            }
        }

        if (len > S.length()) {
            return "";
        }

        return S.substring(start, start + len);
    }
}
