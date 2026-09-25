# Queue (FIFO)

| Category | Method | Return Type | Purpose | Empty Queue Behaviour |
|-----------|----------|------------|----------|----------|
| Insert | add(E e) | boolean | Insert at rear | Exception if fails |
| Insert | offer(E e) | boolean | Insert at rear | false if fails |
| Remove | remove() | E | Remove front | Exception |
| Remove | poll() | E | Remove front | null |
| Peek | element() | E | View front | Exception |
| Peek | peek() | E | View front | null |
| Search | contains(Object o) | boolean | Search element | - |
| Delete Specific | remove(Object o) | boolean | Remove object | false |
| Size | size() | int | Current size | 0 |
| Check | isEmpty() | boolean | Empty or not | true |
| Clear | clear() | void | Remove all elements | - |
| Iterator | iterator() | Iterator<E> | Traverse | - |
| Array | toArray() | Object[] | Convert to array | - |
| Bulk Insert | addAll(Collection) | boolean | Insert collection | - |
| Bulk Search | containsAll(Collection) | boolean | Check all present | - |
| Bulk Delete | removeAll(Collection) | boolean | Remove collection | - |
| Retain | retainAll(Collection) | boolean | Keep only collection elements | - |

---

# Queue Complexity Chart

| Operation | Complexity |
|------------|------------|
| add() | O(1) |
| offer() | O(1) |
| remove() | O(1) |
| poll() | O(1) |
| peek() | O(1) |
| element() | O(1) |
| contains() | O(n) |
| remove(Object) | O(n) |

---

# Deque (Double Ended Queue)

## Front Operations

| Method | Return Type | Purpose |
|----------|------------|----------|
| addFirst(E e) | void | Insert at front |
| offerFirst(E e) | boolean | Insert at front |
| removeFirst() | E | Remove front |
| pollFirst() | E | Remove front |
| getFirst() | E | View front |
| peekFirst() | E | View front |

---

## Rear Operations

| Method | Return Type | Purpose |
|----------|------------|----------|
| addLast(E e) | void | Insert at rear |
| offerLast(E e) | boolean | Insert at rear |
| removeLast() | E | Remove rear |
| pollLast() | E | Remove rear |
| getLast() | E | View rear |
| peekLast() | E | View rear |

---

## Stack Operations (Using Deque)

| Method | Equivalent |
|----------|------------|
| push(E e) | addFirst(E e) |
| pop() | removeFirst() |
| peek() | peekFirst() |

---

## Search & Utility Methods

| Method | Return Type | Purpose |
|----------|------------|----------|
| contains(Object o) | boolean | Search element |
| remove(Object o) | boolean | Remove object |
| removeFirstOccurrence(Object o) | boolean | Remove first occurrence |
| removeLastOccurrence(Object o) | boolean | Remove last occurrence |
| size() | int | Current size |
| isEmpty() | boolean | Empty check |
| clear() | void | Remove all |
| iterator() | Iterator<E> | Front → Rear traversal |
| descendingIterator() | Iterator<E> | Rear → Front traversal |
| toArray() | Object[] | Convert to array |

---

# Deque Complexity Chart

| Operation | Complexity |
|------------|------------|
| addFirst() | O(1) |
| addLast() | O(1) |
| offerFirst() | O(1) |
| offerLast() | O(1) |
| removeFirst() | O(1) |
| removeLast() | O(1) |
| pollFirst() | O(1) |
| pollLast() | O(1) |
| peekFirst() | O(1) |
| peekLast() | O(1) |
| contains() | O(n) |

---

# Priority Queue (Heap)

## Creation

| Type | Syntax |
|--------|--------|
| Min Heap | `new PriorityQueue<>()` |
| Max Heap | `new PriorityQueue<>(Collections.reverseOrder())` |
| Custom Comparator | `new PriorityQueue<>((a,b)->...)` |

---

## Core Operations

| Category | Method | Return Type | Purpose |
|----------|----------|------------|----------|
| Insert | add(E e) | boolean | Insert element |
| Insert | offer(E e) | boolean | Insert element |
| Remove | remove() | E | Remove highest priority |
| Remove | poll() | E | Remove highest priority |
| Peek | element() | E | View highest priority |
| Peek | peek() | E | View highest priority |
| Search | contains(Object o) | boolean | Search element |
| Delete Specific | remove(Object o) | boolean | Remove object |
| Size | size() | int | Current size |
| Empty Check | isEmpty() | boolean | Check empty |
| Clear | clear() | void | Remove all |
| Iterator | iterator() | Iterator<E> | Traverse |
| Array | toArray() | Object[] | Convert to array |
| Bulk Insert | addAll(Collection) | boolean | Insert collection |

---

## Priority Queue Complexity Chart

| Operation | Complexity |
|------------|------------|
| add() | O(log n) |
| offer() | O(log n) |
| poll() | O(log n) |
| remove() | O(log n) |
| peek() | O(1) |
| element() | O(1) |
| contains() | O(n) |
| remove(Object) | O(n) |
| Build Heap | O(n) |

---

# Queue vs Deque vs Priority Queue

| Feature | Queue | Deque | Priority Queue |
|----------|--------|--------|--------|
| Ordering | FIFO | Both Ends | Priority Based |
| Insert Position | Rear | Front + Rear | Heap Position |
| Delete Position | Front | Front + Rear | Highest Priority |
| Peek Position | Front | Front/Rear | Heap Top |
| Supports Stack | No | Yes |
| Supports Queue | Yes | Yes |
| Internal DS | LinkedList/ArrayDeque | ArrayDeque | Binary Heap |
| Search | O(n) | O(n) | O(n) |

---

# Interview Cheat Sheet

| DS | Most Used Methods |
|------|------------------|
| Queue | offer(), poll(), peek() |
| Deque | offerFirst(), offerLast(), pollFirst(), pollLast(), peekFirst(), peekLast() |
| Stack via Deque | push(), pop(), peek() |
| Priority Queue | offer(), poll(), peek() |
| Max Heap | new PriorityQueue<>(Collections.reverseOrder()) |

---

# LeetCode Usage Map

| Data Structure | Famous Problems |
|---------------|----------------|
| Queue | BFS, Level Order Traversal, Rotten Oranges |
| Deque | Sliding Window Maximum, Monotonic Queue |
| Priority Queue | Dijkstra, Prim, Top K Elements |
| Max Heap | K Closest Elements |
| Min Heap | Merge K Sorted Lists |
| Priority Queue + Comparator | Meeting Rooms II, Task Scheduler |