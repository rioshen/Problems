import java.util.LinkedList;
import java.util.List;

/**
 * Created by Robbert on 1/31/15.
 * Insert Interval
 * https://oj.leetcode.com/problems/insert-interval/
 */
public class InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (intervals == null || newInterval == null) {
            return null;
        }

        List<Interval> result = new LinkedList<Interval>();
        int pos = 0;
        for (Interval interval : intervals) {
            if (interval.end < newInterval.start) {
                result.add(interval);
                pos++;
            } else if (interval.start > newInterval.end) {
                result.add(interval);
            } else {
                newInterval.start = Math.min(interval.start, newInterval.start);
                newInterval.end = Math.max(interval.end, newInterval.end);
            }
        }
        result.add(pos, newInterval);

        return result;
    }
}
