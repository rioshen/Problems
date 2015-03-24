import java.util.LinkedList;
import java.util.List;

/**
 * Created by Robbert on 1/25/15.
 * Pascal's Triangle
 * https://oj.leetcode.com/problems/pascals-triangle/
 */
public class PascalTriangle {
    /**
     * Compare with the second line, fill zeros to each empty position.
     * For example, second line is [1, 1] but first line is [1], use zeros
     * fill first line: [0, 1], [1, 0], add them -> [1, 1].
     * Time: O(n), Space:O(n)
     */
    public List<List<Integer>> generateAddtionalSpace(int numRows) {
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

    /**
     * binomial coefficient
     */    
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        if (numRows <= 0) return res;
        for (int i = 1; i <= numRows; i++) {
            List<Integer> level = generateCurrent(i);
            res.add(level);
        }
        return res;
    }
    
    private List<Integer> generateCurrent(int n) {
        if (n < 1) return null;
        List<Integer> result = new LinkedList<Integer>();
        int m = 1;
        result.add(1);
        for (int i = 1; i < n; i++) {
            m = m * (n - i) / i;
            result.add(m);
        }
        return result;
    }
}
