public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        if (version1 == null || version2 == null) {
            throw new IllegalArgumentException();
        }

        // bug 1: split by dot must use regx
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int i = 0, j = 0;
        while (i < v1.length || j < v2.length) {
            int a = i < v1.length ? Integer.parseInt(v1[i]) : 0;
            int b = j < v2.length ? Integer.parseInt(v2[j]) : 0;
            if (a > b) {
                return 1;
            } else if (a < b) {
                return -1;
            }
        }

        return 0;
    }
}