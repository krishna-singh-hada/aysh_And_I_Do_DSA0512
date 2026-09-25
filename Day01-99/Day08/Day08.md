# Day 08

## Greedy Algorithm

- Make the best local choice at every step.
- Never revisit previous decisions.
- Usually combined with sorting.
- Goal: reach the optimal answer with locally optimal choices.

---

## LeetCode 45 - Jump Game II

### Approach

- `currentEnd` = end of current jump range.
- `farthest` = farthest index reachable inside this range.
- Traverse the array and continuously update `farthest`.
- When `i == currentEnd`, we have explored the whole current range.
- A new jump is required, so:
  - Increment `jumps`.
  - Move `currentEnd = farthest`.
- Continue until reaching the last index.

```java
farthest = Math.max(farthest, i + nums[i]);

if (i == currentEnd) {
    jumps++;
    currentEnd = farthest;
}
```

**Time:** `O(n)`  
**Space:** `O(1)`

---

## LeetCode 435 - Non-overlapping Intervals

### Approach

- Sort intervals by ending point.
- Keep the interval that ends earliest.
- For every next interval:
  - If `start >= lastEnd`, keep it.
  - Otherwise it overlaps, so skip it.
- Earlier ending intervals leave more room for future intervals.
- Answer = Total Intervals - Kept Intervals.

```java
Arrays.sort(intervals,
    (a, b) -> Integer.compare(a[1], b[1]));
```

```java
if (intervals[i][0] >= lastEnd) {
    kept++;
    lastEnd = intervals[i][1];
}
```

**Time:** `O(n log n)`  
**Space:** `O(1)` (excluding sorting)

---

## Patterns Learned

### Range Expansion

Used in:
- Jump Game II
- Video Stitching
- Minimum Taps to Water a Garden

### Sort By End

Used in:
- Non-overlapping Intervals
- Activity Selection
- Burst Balloons
- Maximum Events Attended

### Key Idea

> Greedy works when the best choice right now also leads to the best overall answer.