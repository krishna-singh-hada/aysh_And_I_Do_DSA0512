# Day 1: Queue, Deque & Priority Queue Foundations to Hard Patterns

Today I mastered the core mechanics, Java syntax, and optimal design patterns of Queues and Heaps.

## 🧠 Core Definitions
* **Min-Heap**: Binary Tree structure where the parent node is always smaller than its children. Root is always the minimum element. Priority Queue default in Java.
* **Max-Heap**: Parent node is always larger than its children. Root is always the maximum element. Constructed using `Collections.reverseOrder()`.

## 🛠️ Java Syntax & Logic
* **Queue**: `Queue<T> q = new LinkedList<>();` -> FIFO (First In, First Out).
* **Deque**: `Deque<T> dq = new ArrayDeque<>();` -> Double-ended, highly optimized insertion/removal from both ends.
* **Priority Queue (Max)**: `PriorityQueue<T> pq = new PriorityQueue<>(Collections.reverseOrder());` -> Elements prioritized based on custom/natural ordering.

## 🚀 Topics & Patterns Covered
1. **Queue Implementation via Stacks**: Amortized $O(1)$ operations using dynamic shifts.
2. **K-Closest Points**: Custom Heap Comparators utilizing $O(N \log K)$ space-bounding strategy.
3. **K-Way Merging**: Merging $K$ sorted datasets in $O(N \log K)$ time using Min-Heaps.
4. **Monotonic Deque**: Maintaining sorted index ranges in $O(N)$ for sliding window boundaries.

## 🎯 Solved Problems List

* LeetCode 1046: Last Stone Weight (Max-Heap)
* LeetCode 232: Implement Queue using Stacks (Two Stacks Logic)
* LeetCode 973: K Closest Points to Origin (Custom Comparator Max-Heap)
* LeetCode 23: Merge k Sorted Lists (In-place pointer rewiring via Min-Heap)
