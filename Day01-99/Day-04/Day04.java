import java.util.*;
/*
====================================================
DAY 4 - DYNAMIC PROGRAMMING
====================================================

Topics Covered:

1. 70. Climbing Stairs
2. 746. Min Cost Climbing Stairs
3. 198. House Robber
4. 3524. Find X Value of Array I

----------------------------------------------------
DP CHECKLIST
----------------------------------------------------

1. State
   dp[i] means ?

2. Base Case
   Starting values

3. Transition
   How current state is formed

4. Answer
   Which state contains final answer

====================================================
70. CLIMBING STAIRS
====================================================

State:
dp[i] = ways to reach stair i

Base:
dp[0] = 1
dp[1] = 1

Transition:
dp[i] = dp[i-1] + dp[i-2]

Answer:
dp[n]

Time Complexity:
O(n)

Space Complexity:
O(n)
*/

class ClimbingStairs {

    public int climbStairs(int n) {

        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {

            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}

/*
====================================================
746. MIN COST CLIMBING STAIRS
====================================================

State:
dp[i] = minimum cost required
        to stand on stair i

Base:
dp[0] = cost[0]
dp[1] = cost[1]

Transition:
dp[i]
=
cost[i]
+
min(dp[i-1], dp[i-2])

Answer:
min(dp[n-1], dp[n-2])

Time Complexity:
O(n)

Space Complexity:
O(n)
*/

class MinCostClimbingStairs {

    public int minCostClimbingStairs(int[] cost) {

        int n = cost.length;

        int[] dp = new int[n];

        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i < n; i++) {

            dp[i] = cost[i]
                    + Math.min(dp[i - 1], dp[i - 2]);
        }

        return Math.min(dp[n - 1], dp[n - 2]);
    }
}

/*
====================================================
198. HOUSE ROBBER
====================================================

Pattern:
Take / Skip

State:
dp[i]
=
maximum money obtainable till house i

Choices:

1. Skip Current House

dp[i-1]

2. Take Current House

nums[i] + dp[i-2]

Transition:

dp[i]
=
max(
    dp[i-1],
    nums[i] + dp[i-2]
)

Base:

dp[0] = nums[0]

dp[1]
=
max(nums[0], nums[1])

Answer:

dp[n-1]

Time Complexity:
O(n)

Space Complexity:
O(n)
*/

class HouseRobber {

    public int rob(int[] nums) {

        int n = nums.length;

        if (n == 1) {
            return nums[0];
        }

        int[] dp = new int[n];

        dp[0] = nums[0];

        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {

            dp[i] = Math.max(
                    dp[i - 1],
                    nums[i] + dp[i - 2]
            );
        }

        return dp[n - 1];
    }
}

/*
====================================================
3524. FIND X VALUE OF ARRAY I
====================================================

Pattern:
State DP

Observation:

Removing Prefix + Suffix
=
Choosing a Subarray

State:

bucket[r]

Meaning:

How many subarrays ending at current
position have remainder r.

Transition:

currentRem = num % k

newRem
=
(oldRem * currentRem) % k

Idea:

Move all counts from old bucket
to new bucket.

Time Complexity:
O(n * k)

Space Complexity:
O(k)
*/

class FindXValueOfArrayI {

    public long[] resultArray(int[] nums, int k) {

        long[] ans = new long[k];

        long[] preCount = new long[k];

        for (int num : nums) {

            int currentRem = num % k;

            long[] currentCount = new long[k];

            // Start fresh subarray
            currentCount[currentRem]++;

            // Extend previous subarrays
            for (int oldRem = 0; oldRem < k; oldRem++) {

                int newRem =
                        (oldRem * currentRem) % k;

                currentCount[newRem] += preCount[oldRem];
            }

            // Add current subarrays
            for (int rem = 0; rem < k; rem++) {

                ans[rem] += currentCount[rem];
            }

            preCount = currentCount;
        }

        return ans;
    }
}

/*
====================================================
DAY 4 TAKEAWAYS
====================================================

1. DP starts with STATE.

2. Always define:

   dp[i] = ?

3. Then find:

   How can I arrive here?

4. Then:

   Base Case

5. Then:

   Transition

6. Then:

   Answer

----------------------------------------------------

DP Families Learned:

1. Count DP
   - Climbing Stairs

2. Min DP
   - Min Cost Climbing Stairs

3. Max DP
   - House Robber

4. State DP
   - Find X Value of Array I

----------------------------------------------------

Golden Rule:

If you cannot explain:

dp[i] = ?

You are not ready to code yet.

====================================================
*/
