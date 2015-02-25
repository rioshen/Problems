import java.util.Arrays;
import java.util.Comparator;
import java.util.Collections;
import java.util.List;
import java.util.LinkedList;

public class LargestNumber {
    public String largestNumber(int[] num) {
        if (num == null || num.length == 0) {
            return "0";
        }

        List<String> content = new LinkedList<String>();
        for (int elem : num) {
            content.add(String.valueOf(elem));
        }

        Collections.sort(content, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                Double t1 = Double.valueOf(a + b);
                Double t2 = Double.valueOf(b + a);
                return t2.compareTo(t1);
            }
        });
        if (content.get(0).equals("0")) {
            return "0";
        }

        StringBuilder result = new StringBuilder();
        for (String elem : content) {
            result.append(elem);
        }
        return result.toString();
    }
}
