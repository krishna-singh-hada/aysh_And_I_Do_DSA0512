

import java.util.*;

// LeetCode 45 - Jump Game II

class JumpGameII {

    public int jump(int[] nums) {

        if (nums.length <= 1) return 0;

        int currentEnd = 0;
        int farthest = 0;
        int jumpCount = 0;

        for (int i = 0; i < nums.length - 1; i++) {

            farthest = Math.max(farthest, i + nums[i]);

            if (currentEnd == i) {
                jumpCount++;
                currentEnd = farthest;
            }

            if (currentEnd >= nums.length - 1) {
                break;
            }
        }

        return jumpCount;
    }
}


// LeetCode 435 - Non-overlapping Intervals

class NonOverlappingIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {

        if (intervals.length <= 1) return 0;

        Arrays.sort(
            intervals,
            (a, b) -> Integer.compare(a[1], b[1])
        );

        int lastEnd = intervals[0][1];
        int kept = 1;

        for (int i = 1; i < intervals.length; i++) {

            int currentStart = intervals[i][0];
            int currentEnd = intervals[i][1];

            if (lastEnd <= currentStart) {
                lastEnd = currentEnd;
                kept++;
            }
        }

        return intervals.length - kept;
    }
}