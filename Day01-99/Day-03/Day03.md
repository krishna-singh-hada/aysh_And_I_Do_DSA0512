# 🚀 Day 03 - LeetCode Journey
### 📅 Date: 20-09-2026

## ✅ Questions Solved

### 1. Maximum Side Length of a Square With Sum ≤ Threshold
**Topics:** 2D Prefix Sum, Binary Search on Answer

**Approach**
- Build 2D Prefix Sum.
- Binary Search on square size.
- Check whether any square of size `mid` has sum ≤ threshold.
- If valid, search bigger sizes.
- Otherwise reduce size.

**Flow**

```text
Build Prefix Sum
       ↓
Choose Mid Size
       ↓
Square Exists?
   ↙       ↘
 Yes       No
  ↓         ↓
Size+1   Size-1
```

**Time:** `O(rows * cols * log(min(rows, cols)))`  
**Space:** `O(rows * cols)`

---

### 2. Count Submatrices With Sum Less Than K
**Topics:** 2D Prefix Sum

**Approach**
- Build prefix sum while traversing.
- Every prefix already represents rectangle `(0,0) → (i,j)`.
- Count whenever prefix sum ≤ k.

**Flow**

```text
Build Prefix
      ↓
Prefix ≤ K ?
   ↙      ↘
 Yes      No
  ↓
Count++
```

**Time:** `O(rows * cols)`  
**Space:** `O(rows * cols)`

---

### 3. Subsets
**Topics:** Backtracking

**Approach**
- Every element has two choices.
- Take it.
- Skip it.
- Store answer at base condition.

**Flow**

```text
Element
 ├── Take
 └── Skip
```

**Time:** `O(n * 2^n)`  
**Space:** `O(n)`

---

### 4. Subsets II
**Topics:** Backtracking, Duplicates

**Approach**
- Sort array.
- Generate all subsets.
- Skip duplicate branches.

```java
if(i > index && nums[i] == nums[i - 1])
    continue;
```

**Flow**

```text
Sort
 ↓
Duplicate?
 ↙      ↘
Yes     No
 ↓       ↓
Skip   Explore
```

**Time:** `O(n * 2^n)`  
**Space:** `O(n)`

---

# 📚 Topics Learned

- 2D Prefix Sum
- Binary Search on Answer
- Backtracking
- Duplicate Handling in Backtracking

---

# 📝 Backtracking Notes

### Standard Pattern

```text
Choose
 ↓
Explore
 ↓
Undo Choice
 ↓
Explore Again
```

### Template

```java
choose();

backtrack();

undoChoice();
```

---

# 🎯 Today's Takeaways

✅ Prefix Sum makes rectangle and square queries fast.

✅ Binary Search can be applied on answer space.

✅ Backtracking = Choose → Explore → Undo.

✅ Sorting helps handle duplicate states.

✅ Not every problem is tough if it looks big 

✅ Break:
Problem → Pattern → Solution

---

**Day 03 Status:** ✅ Commit Pushed