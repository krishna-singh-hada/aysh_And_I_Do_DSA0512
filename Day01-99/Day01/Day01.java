/*
=========================================
DAY 01 - INTERVALS
=========================================

LC 56  - Merge Intervals
LC 57  - Insert Interval
LC 435 - Non-overlapping Intervals
LC 1288 - Remove Covered Intervals
LC 452 - Minimum Number of Arrows to Burst Balloons

Topics Learned:
- Sort By Start
- Sort By End
- Merge Intervals
- Coverage
- Greedy Interval Selection
=========================================
*/

import java.util.*;
// LC 56 - Merge Intervals
class MergeIntervals {

    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals,
                (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();

        result.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {

            int[] last = result.get(result.size() - 1);
            int[] current = intervals[i];

            if (current[0] <= last[1]) {

                last[1] =
                        Math.max(last[1], current[1]);

            } else {

                result.add(current);
            }
        }

        return result.toArray(
                new int[result.size()][]
        );
    }
}


// LC 57 - Insert Interval
class InsertInterval {

    public int[][] insert(
            int[][] intervals,
            int[] newInterval) {

        int[][] all =
                new int[intervals.length + 1][2];

        for (int i = 0; i < intervals.length; i++) {
            all[i] = intervals[i];
        }

        all[all.length - 1] = newInterval;

        Arrays.sort(all,
                (a, b) ->
                        Integer.compare(a[0], b[0]));

        List<int[]> result =
                new ArrayList<>();

        result.add(all[0]);

        for (int i = 1; i < all.length; i++) {

            int[] last =
                    result.get(result.size() - 1);

            int[] current = all[i];

            if (current[0] <= last[1]) {

                last[1] =
                        Math.max(last[1],
                                current[1]);

            } else {

                result.add(current);
            }
        }

        return result.toArray(
                new int[result.size()][]
        );
    }
}


// LC 435 - Non-overlapping Intervals
class NonOverlappingIntervals {

    public int eraseOverlapIntervals(
            int[][] intervals) {

        Arrays.sort(intervals,
                (a, b) ->
                        Integer.compare(a[0], b[0]));

        int removed = 0;

        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {

            if (intervals[i][0] < end) {

                removed++;

                end =
                        Math.min(
                                end,
                                intervals[i][1]
                        );

            } else {

                end = intervals[i][1];
            }
        }

        return removed;
    }
}


// LC 1288 - Remove Covered Intervals
class RemoveCoveredIntervals {

    public int removeCoveredIntervals(
            int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> {

            if (a[0] == b[0]) {

                return Integer.compare(
                        b[1],
                        a[1]
                );
            }

            return Integer.compare(
                    a[0],
                    b[0]
            );
        });

        int covered = 0;

        int[] prev = intervals[0];

        for (int i = 1; i < intervals.length; i++) {

            int[] current = intervals[i];

            if (prev[1] >= current[1]) {

                covered++;

            } else {

                prev = current;
            }
        }

        return intervals.length - covered;
    }
}


// LC 452 - Minimum Number of Arrows to Burst Balloons
class MinimumArrows {

    public int findMinArrowShots(
            int[][] points) {

        Arrays.sort(points,
                (a, b) ->
                        Integer.compare(a[1], b[1]));

        int arrows = 1;

        int arrowPosition = points[0][1];

        for (int i = 1; i < points.length; i++) {

            if (points[i][0] > arrowPosition) {

                arrows++;

                arrowPosition = points[i][1];
            }
        }

        return arrows;
    }
}