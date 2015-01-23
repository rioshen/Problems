import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * Created by Robbert on 1/23/15.
 */
public class MajorityNumber {
    public int majorityElement(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }
        Arrays.sort(num);
        return num[num.length / 2];
    }

    public int majorityElement2(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int element : num) {
            if (!map.containsKey(element)) {
                map.put(element, 1);
            } else {
                map.put(element, map.get(element) + 1);
            }
        }

        for (Integer key : map.keySet()) {
            if (map.get(key) > num.length / 2) {
                return key;
            }
        }

        throw new NoSuchElementException();
    }

    public int majorityElement3(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }

        int counter = 1;
        int majority = 0;
        for (int element : num) {
            if (majority == element) {
                counter++;
            } else {
                counter--;
            }
            if (counter == 0) {
                majority = element;
                counter = 1;
            }
        }

        return majority;
    }
}
