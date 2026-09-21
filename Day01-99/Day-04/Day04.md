# Dynamic Programming (DP)

## What is DP?

Dynamic Programming is a technique where we solve a problem using answers of smaller subproblems and store those answers to avoid recomputation.

Core Idea:

```text
Solve Once
Store Once
Reuse Forever
```

---

# When Should I Think Of DP?

If the problem asks for:

```text
Maximum
Minimum
Count Ways
Possible / Not Possible
```

And:

```text
Current answer depends on previous answers
```

Then DP is a strong candidate.

---

# DP Building Blocks

Every DP problem has 4 parts:

## 1. State

Question:

```text
What does dp[i] represent?
```

Examples:

```text
Climbing Stairs:
dp[i] = ways to reach stair i

House Robber:
dp[i] = maximum money till house i

Min Cost Climbing Stairs:
dp[i] = minimum cost to stand on stair i
```

---

## 2. Base Case

Starting values.

Example:

```java
dp[0] = 1;
dp[1] = 1;
```

Without base cases no future states can be generated.

---

## 3. Transition

How current state is formed.

Example:

```java
dp[i] = dp[i-1] + dp[i-2];
```

Question to ask:

```text
How can I arrive at state i?
```

---

## 4. Answer

Final destination.

Examples:

```java
return dp[n];
return dp[n-1];
```

---

# My DP Strategy

Whenever I see a DP problem:

## Step 1

Define State

```text
dp[i] = ?
```

## Step 2

Ask

```text
How can I reach this state?
```

## Step 3

Derive Transition

## Step 4

Write Base Cases

## Step 5

Return Answer

---

# Pattern 1: Count DP

Question Type:

```text
How many ways?
```

Examples:

```text
70. Climbing Stairs
62. Unique Paths
518. Coin Change II
```

Typical Transition:

```java
dp[i] = dp[i-1] + dp[i-2];
```

---

# Pattern 2: Min / Max DP

Question Type:

```text
Maximum?
Minimum?
```

Examples:

```text
198. House Robber
746. Min Cost Climbing Stairs
```

Typical Transition:

```java
dp[i] = Math.max(...)
```

or

```java
dp[i] = Math.min(...)
```

---

# Pattern 3: Take / Not Take DP

Question:

```text
Should I pick this element?
```

Choices:

```text
Take
Skip
```

Examples:

```text
198. House Robber
416. Partition Equal Subset Sum
494. Target Sum
0/1 Knapsack
```

Generic Template:

```java
take = ...
skip = ...

answer = combine(take, skip);
```

---

# Pattern 4: State DP

State is not index-based.

Example:

```text
3524. Find X Value of Array I
```

State:

```text
remainder
```

Transition:

```java
newRem = (oldRem * curRem) % k;
```

Idea:

```text
Move counts between state buckets.
```

---

# Solved Problems

## 70. Climbing Stairs

State:

```text
dp[i] = ways to reach stair i
```

Transition:

```java
dp[i] = dp[i-1] + dp[i-2];
```

Complexity:

```text
Time: O(n)
Space: O(n)
```

---

## 746. Min Cost Climbing Stairs

State:

```text
dp[i] = min cost to reach stair i
```

Transition:

```java
dp[i] = cost[i] + min(dp[i-1], dp[i-2]);
```

Complexity:

```text
Time: O(n)
Space: O(n)
```

---

## 198. House Robber

State:

```text
dp[i] = max money till house i
```

Choices:

```text
Take current house
Skip current house
```

Transition:

```java
dp[i] =
max(
    dp[i-1],
    nums[i] + dp[i-2]
);
```

Complexity:

```text
Time: O(n)
Space: O(n)
```

---

## 3524. Find X Value of Array I

Observation:

```text
Removing Prefix + Suffix
=
Choosing a Subarray
```

State:

```text
bucket[r]
=
count of subarrays ending here
having remainder r
```

Transition:

```java
newRem = (oldRem * curRem) % k;
```

Complexity:

```text
Time: O(n * k)
Space: O(k)
```

---

# Golden Rule

Most DP bugs happen because:

```text
State is defined incorrectly.
```

Before writing code always answer:

```text
What does dp[i] mean?
```

If that answer is clear, the transition usually becomes obvious.