import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Stack;

// =========================================================================
// 🏛️ BASIC CORE DATA STRUCTURES (Separate Helper Classes)
// =========================================================================

/**
 * Basic Core Class: ListNode
 * Purpose: Standard Singly-Linked List Node used for pointer-manipulation questions.
 */
class ListNode {
    int val;
    ListNode next;
    
    ListNode() {}
    
    ListNode(int val) { 
        this.val = val; 
    }
    
    ListNode(int val, ListNode next) { 
        this.val = val; 
        this.next = next; 
    }
}

// =========================================================================
// 🚀 LEETCODE SOLUTIONS (Package-Private Classes for Single-File Compilation)
// =========================================================================

/**
 * LeetCode 1046: Last Stone Weight
 * Category: Easy (Priority Queue - Max Heap)
 * Purpose: Find the last remaining stone weight by repeatedly smashing the two heaviest stones.
 */
class LastStoneWeight {
    public int lastStoneWeight(int[] nums) {
        if (nums.length == 1) return nums[0];

        // Max-Heap: Largest elements stay on top
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int stone : nums) {
            maxHeap.offer(stone);
        }

        while (maxHeap.size() > 1) {
            int stone1 = maxHeap.poll(); // Heaviest
            int stone2 = maxHeap.poll(); // Second heaviest

            if (stone1 != stone2) {
                maxHeap.offer(stone1 - stone2);
            }
        }

        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }
}

/**
 * LeetCode 232: Implement Queue using Stacks
 * Category: Easy (Two-Stack FIFO simulation)
 * Purpose: Simulates standard FIFO Queue using two LIFO Stacks with Amortized O(1) reads.
 */
class MyQueue {
    private Stack<Integer> a; // For input ingestion
    private Stack<Integer> b; // For output polling

    public MyQueue() {
        a = new Stack<>();
        b = new Stack<>();
    }

    public void push(int x) {
        a.push(x);
    }

    public int pop() {
        shiftStacks();
        return b.pop();
    }

    public int peek() {
        shiftStacks();
        return b.peek();
    }

    public boolean empty() {
        return a.isEmpty() && b.isEmpty();
    }

    // Transfers elements only when necessary, reversing LIFO to FIFO order
    private void shiftStacks() {
        if (b.isEmpty()) {
            while (!a.isEmpty()) {
                b.push(a.pop());
            }
        }
    }
}

/**
 * LeetCode 973: K Closest Points to Origin
 * Category: Medium (Priority Queue with Custom Comparator)
 * Purpose: Finds K closest coordinates on 2D plane to origin using a bounded Max-Heap.
 */
class KClosestPoints {
    public int[][] kClosest(int[][] points, int k) {
        // Custom Comparator: Sorts coordinates based on descending Euclidean distance square
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> {
            int distA = a[0]*a[0] + a[1]*a[1];
            int distB = b[0]*b[0] + b[1]*b[1];
            return Integer.compare(distB, distA); 
        });

        for (int[] point : points) {
            maxHeap.offer(point);
            if (maxHeap.size() > k) {
                maxHeap.poll(); // Discard the furthest point
            }
        }

        int[][] result = new int[k][2];
        int index = 0;
        while (!maxHeap.isEmpty()) {
            result[index++] = maxHeap.poll();
        }

        return result;
    }
}

/**
 * LeetCode 23: Merge k Sorted Lists
 * Category: Hard (K-Way Merge Pattern)
 * Purpose: Merges K pre-sorted Linked Lists in O(N log K) using a Min-Heap.
 */
class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        // Min-Heap: Smallest node value prioritized
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));

        // Seed heap with initial nodes
        for (ListNode node : lists) {
            if (node != null) {
                minHeap.offer(node);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (!minHeap.isEmpty()) {
            ListNode smallest = minHeap.poll();
            tail.next = smallest; // In-place linkage
            tail = tail.next;

            if (smallest.next != null) {
                minHeap.offer(smallest.next);
            }
        }

        return dummy.next;
    }
}

/**
 * LeetCode 239: Sliding Window Maximum
 * Category: Hard (Monotonic Deque Pattern)
 * Purpose: Returns the maximum element for every sliding window of size K in linear O(N) time.
 */
class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];

        int n = nums.length;
        int[] result = new int[n - k + 1];
        int ri = 0;

        // Stores indices of elements in strictly decreasing order
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            // Remove out-of-bounds index
            if (!dq.isEmpty() && dq.peekFirst() < i - k + 1) {
                dq.pollFirst();
            }

            // Monotonic property: Keep only elements larger than nums[i]
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }

            dq.offerLast(i);

            // Fetch the maximum once window is fully initialized
            if (i >= k - 1) {
                result[ri++] = nums[dq.peekFirst()];
            }
        }

        return result;
    }
}

// =========================================================================
// 📦 MAIN ENTRY POINT
// =========================================================================

/**
 * Public class matching the filename 'day06.java'
 */
public class Day06 {
    public static void main(String[] args) {
        System.out.println("Day 06 compilation test: Success.");
        System.out.println("All basic core structures and LeetCode classes consolidated.");
    }
}
