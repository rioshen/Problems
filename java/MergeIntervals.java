import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by terry on 1/6/15.
 */
class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class MergeIntervals {
    public List<Interval> mergeIntervals(List<Interval> intervals) {
        List<Interval> result = new ArrayList<Interval>();
        if (intervals == null) return result;

        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval interval, Interval t1) {
                return interval.start - t1.start;
            }
        });

        Interval previous = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval current = intervals.get(i);
            if (current.start <= previous.end) {
                previous.end = Math.max(previous.end, current.end);
            } else {
                result.add(previous);

                // if the loop terminates right after this part
                // don't forget add this current interval again!!
                previous = current;
            }
        }
        result.add(previous);

        return result;
    }
}
