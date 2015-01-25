import java.util.LinkedList;
import java.util.List;

/**
 * Created by Robbert on 1/25/15.
 * Pascal's Triangle
 * https://oj.leetcode.com/problems/pascals-triangle/
 */
public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (numRows <= 0) {
            return result;
        }

        LinkedList<Integer> prev = new LinkedList<Integer>();
        prev.add(1);
        result.add(new LinkedList<Integer>(prev));
        for (int i = 2; i <= numRows; i++) {
            prev = paddingZero(prev);
            result.add(new LinkedList<Integer>(prev));
        }

        return result;
    }

    private LinkedList<Integer> paddingZero(LinkedList<Integer> list) {
        LinkedList<Integer> a = new LinkedList<Integer>();
        a.addAll(list);
        a.addFirst(0);
        LinkedList<Integer> b = new LinkedList<Integer>();
        b.addAll(list);
        b.addLast(0);
        LinkedList<Integer> result = new LinkedList<Integer>();
        for (int i = 0; i < a.size(); i++) {
            result.add(a.get(i) + b.get(i));
        }
        return result;
    }
}
