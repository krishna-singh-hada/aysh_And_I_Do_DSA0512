# Day 2: 2D Prefix Sum

## ✅ Learned

### 2D Prefix Matrix

```java
prefix[i][j] =
matrix[i][j]
+ top
+ left
- diagonal;
```

`prefix[i][j]` stores the sum from `(0,0)` → `(i,j)`.

---

### Rectangle Query

```java
sum =
prefix[r2][c2]
- prefix[r1-1][c2]
- prefix[r2][c1-1]
+ prefix[r1-1][c1-1];
```

Mental model:

```text
BIG
- TOP
- LEFT
+ OVERLAP
```

---

## ✅ LeetCode 304

**Range Sum Query 2D**

- Built 2D Prefix Matrix
- Queried any rectangle in O(1)

---

## ✅ LeetCode 1314

**Matrix Block Sum**

Convert block to rectangle:

```java
r1 = Math.max(0, i-k);
c1 = Math.max(0, j-k);

r2 = Math.min(rows-1, i+k);
c2 = Math.min(cols-1, j+k);
```

Then use the rectangle query formula.

---

## 📌 Useful Syntax

```java
Math.max(0, value);
Math.min(limit, value);
```

```java
int top = (i > 0)
        ? prefix[i-1][j]
        : 0;
```

---

## 🚀 Key Takeaway

```text
Many Rectangle Queries
→ 2D Prefix Sum

Block Sum
→ Rectangle Query
→ 2D Prefix Sum
```

### Completed
d
- [x] 2D Prefix Matrix
- [x] Rectangle Sum Query
- [x] LC 304
- [x] LC 1314