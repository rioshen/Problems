public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        if (version1 == null || version2 == null) {
            throw new IllegalArgumentException();
        }

        // bug 1: split by dot must use regx
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int l1 = v1.length, l2 = v2.length;
        int maxlen = Math.max(l1, l2);
        for (int i = 0; i < maxlen; i++) {
            int c1 = l1 <= i ? 0 : Integer.parseInt(v1[i]);
            int c2 = l2 <= i ? 0 : Integer.parseInt(v2[i]);
            if (c1 > c2) {
                return 1;
            } else if (c1 < c2){ // bug2: forget the comparison condition 
                return -1;
            }
        }

        return 0;
    }
}