# Day 09 - Sliding Window

## Questions Solved

---

### 1. Minimum Queen Moves

**Topic:** Chess Simulation / Math

**Approach:**
If source and target are same -> 0 moves.

If queen can reach directly using:
- Same Row
- Same Column
- Same Diagonal

Then answer = 1.

Otherwise answer = 2.

**Time:** O(1)

**Space:** O(1)

---

### 2. Fruit Into Baskets

**Topic:** Sliding Window + HashMap

**Approach:**
Maintain a window containing at most 2 fruit types.

Expand from right.

Whenever fruit types become greater than 2,
shrink window from left.

Track maximum valid window size.

**Time:** O(n)

**Space:** O(2) ≈ O(1)

---

### 3. Longest Subarray of 1's After Deleting One Element

**Topic:** Sliding Window

**Approach:**
Allow at most one zero inside window.

If zero count exceeds one,
shrink from left.

Window length gives answer,
subtract one because exactly one element must be deleted.

**Time:** O(n)

**Space:** O(1)

---

### 4. Max Consecutive Ones III

**Topic:** Sliding Window

**Approach:**
Treat k as available flips.

Maintain window having at most k zeros.

If zero count exceeds k,
shrink from left.

Keep maximum valid window size.

**Time:** O(n)

**Space:** O(1)

---

## Concepts Learned

- Fixed vs Variable Sliding Window
- Expanding Window using Right Pointer
- Shrinking Window using Left Pointer
- Zero Count Tracking
- Frequency Map Maintenance
- At Most K Condition
- Window Validation Logic
- Chess Diagonal Property

---

## Sliding Window Template

```java
int left = 0;

for(int right = 0; right < n; right++){

    // add current element

    while(window invalid){

        // remove left element

        left++;
    }

    ans = Math.max(ans,right-left+1);
}
```

---

## Revision Notes

- Window always expands using right.
- Window always shrinks using left.
- Count extra elements before shrinking.
- "At most K" -> classic sliding window.
- HashMap is used when tracking frequencies.
- Zero based constraints often become count variables.
- Queen moves diagonally when:
  abs(r1-r2) == abs(c1-c2)

