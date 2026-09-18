# Day 01 - Intervals Solved
LC 56 Merge Intervals
LC 57 Insert Interval
LC 435 Non-overlapping Intervals
LC 1288 Remove Covered Intervals
LC 452 Minimum Arrows to Burst Balloons
# Learned
Intervals are simply [start, end]
Most interval problems start with sorting
Merge problems usually sort by start
Greedy interval problems often care about end
Smaller ending points leave more room for future intervals
One interval can overlap, merge, or cover another
Sorting Patterns

# Sort by Start:
 Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));

# Sort by End: 
Arrays.sort(intervals, (a,b) -> Integer.compare(a[1], b[1]));

# Same Start? Bigger End First: [1,10] comes before [1,5]

# Key Intuitions

LC 56: Sort by start and merge overlapping intervals.

LC 57: Insert new interval, sort, then merge again.

LC 435: When intervals overlap, keep the one with the smaller ending point.

LC 1288: If a previous interval completely contains the current interval, it is covered.

LC 452: Shoot an arrow at the earliest ending interval to burst maximum balloons.
