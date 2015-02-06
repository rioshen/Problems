import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class MaxPointsonALine {
    /**
     * Three cases two points could be on the same line
     * 1. a.x == b.x
     * 2. a.y == b.y
     * 3. a.y - b.y / a.x - b.x == c.y - b.y / c.x - b.x
     * We can use a hash map to store {slope: number}, and another variable to store the maximum one.
     * use a nested loop to compare each of them.
     * One more thing need to consider is duplicate points, if two points are duplicates,
     */
    public int maxPoints(Point[] points) {
        if (points == null || points.length == 0) return 0;

        Map<Double, Integer> map = new HashMap<Double, Integer>();
        int maxPoints = 0;
        // bug 1: init duplicate to 1, because at least a point is on the same line of itself
        int duplicate = 1;
        for (int i = 0; i < points.length; i++) {
            duplicate = 1;
            Point prev = points[i];
            map.clear();
            for (int j = 0; j < points.length; j++) {
                if (i == j) continue;
                Point curr = points[j];
                // duplicate points
                if (isDuplicatePoint(prev, curr)) {
                    duplicate++;
                    continue;
                }
                // same slope
                double slope = getSlope(prev, curr);
                map.put(slope, map.containsKey(slope) ? map.get(slope) + 1 : 1);

            }

            // bug 2: if only contains duplicates, need to update maxPoints
            if (map.keySet().size() == 0) {
                maxPoints = duplicate;
            }
            for (int p : map.values()) {
                maxPoints = Math.max(maxPoints, p + duplicate);
            }
        }

        return maxPoints;
    }

    private boolean isDuplicatePoint(Point p, Point q) {
        return p.x == q.x && p.y == q.y;
    }

    private double getSlope(Point p, Point q) {
        if (p.x == q.x) {
            return Integer.MAX_VALUE;
        } else if (p.y == q.y) {
            return 0.0;
        } else {
            // bug 3: can't use abs() method
            return 1.0 * (q.y - p.y) / (q.x - p.x);
        }
    }
}