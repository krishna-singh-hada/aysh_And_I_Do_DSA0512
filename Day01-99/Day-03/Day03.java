/*
=================================================
DAY 03
Date : 20-09-2026

Topics:
1. 2D Prefix Sum
2. Binary Search on Answer
3. Backtracking
4. Duplicate Handling

Questions:
1. Maximum Side Length of a Square <= Threshold
2. Count Submatrices With Sum <= K
3. Subsets
4. Subsets II
=================================================
*/

import java.util.*;

/*
=================================================
Problem 1
Maximum Side Length of a Square <= Threshold

Time:
O(rows * cols * log(min(rows, cols)))

Space:
O(rows * cols)
=================================================
*/

public class Day03{
    public static void main(String[] args) {
        System.out.println("Hey today was sunday , 20-09-2026 , kinda peaceful it was :) ");
    }
}

class MaximumSideLength {

    public int maxSideLength(int[][] mat, int threshold) {

        int rows = mat.length;
        int cols = mat[0].length;

        int[][] prefix = makePrefix(mat);

        int left = 1;
        int right = Math.min(rows, cols);

        int result = 0;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (canMake(prefix, threshold, mid, rows, cols)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    private int[][] makePrefix(int[][] mat) {

        int[][] pre = new int[mat.length][mat[0].length];

        for (int i = 0; i < mat.length; i++) {

            for (int j = 0; j < mat[0].length; j++) {

                int top = (i > 0) ? pre[i - 1][j] : 0;
                int left = (j > 0) ? pre[i][j - 1] : 0;
                int diagonal = (i > 0 && j > 0) ? pre[i - 1][j - 1] : 0;

                pre[i][j] = mat[i][j] + top + left - diagonal;
            }
        }

        return pre;
    }

    private boolean canMake(
            int[][] prefix,
            int threshold,
            int size,
            int rows,
            int cols) {

        for (int i = 0; i + size - 1 < rows; i++) {

            for (int j = 0; j + size - 1 < cols; j++) {

                int r2 = i + size - 1;
                int c2 = j + size - 1;

                if (squareSum(prefix, i, j, r2, c2) <= threshold) {
                    return true;
                }
            }
        }

        return false;
    }

    private int squareSum(
            int[][] prefix,
            int r1,
            int c1,
            int r2,
            int c2) {

        int total = prefix[r2][c2];

        int top = (r1 > 0) ? prefix[r1 - 1][c2] : 0;
        int left = (c1 > 0) ? prefix[r2][c1 - 1] : 0;
        int overlap = (r1 > 0 && c1 > 0)
                ? prefix[r1 - 1][c1 - 1]
                : 0;

        return total - top - left + overlap;
    }
}

/*
=================================================
Problem 2
Count Submatrices With Sum <= K

Time:
O(rows * cols)

Space:
O(rows * cols)
=================================================
*/

class CountSubMatrices {

    public int countSubmatrices(int[][] grid, int k) {

        int rows = grid.length;
        int cols = grid[0].length;

        int[][] prefix = new int[rows][cols];

        int count = 0;

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                int top = (i > 0) ? prefix[i - 1][j] : 0;
                int left = (j > 0) ? prefix[i][j - 1] : 0;
                int diagonal =
                        (i > 0 && j > 0)
                                ? prefix[i - 1][j - 1]
                                : 0;

                prefix[i][j] =
                        grid[i][j]
                                + top
                                + left
                                - diagonal;

                if (prefix[i][j] <= k) {
                    count++;
                }
            }
        }

        return count;
    }
}

/*
=================================================
Problem 3
Subsets

Time:
O(n * 2^n)

Space:
O(n)
=================================================
*/

class Subsets {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {

        backTrack(
                0,
                nums,
                new ArrayList<>());

        return ans;
    }

    private void backTrack(
            int index,
            int[] nums,
            List<Integer> path) {

        if (index == nums.length) {

            ans.add(new ArrayList<>(path));
            return;
        }

        path.add(nums[index]);

        backTrack(index + 1, nums, path);

        path.remove(path.size() - 1);

        backTrack(index + 1, nums, path);
    }
}

/*
=================================================
Problem 4
Subsets II

Time:
O(n * 2^n)

Space:
O(n)
=================================================
*/

class SubsetsII {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);

        backTrack(
                0,
                nums,
                new ArrayList<>());

        return ans;
    }

    private void backTrack(
            int index,
            int[] nums,
            List<Integer> current) {

        ans.add(new ArrayList<>(current));

        for (int i = index; i < nums.length; i++) {

            if (i > index
                    && nums[i] == nums[i - 1]) {
                continue;
            }

            current.add(nums[i]);

            backTrack(
                    i + 1,
                    nums,
                    current);

            current.remove(
                    current.size() - 1);
        }
    }
}

/*
=================================================
REVISION NOTES

2D Prefix Sum

prefix[i][j] =
current
+ top
+ left
- diagonal

---------------------------------

Binary Search On Answer

If size works:
    try larger size

Else:
    reduce size

---------------------------------

Backtracking

Choose
↓
Explore
↓
Undo Choice

---------------------------------

Subsets

Take
or
Don't Take

---------------------------------

Subsets II

Sort Array

Skip Duplicate Branches

if(i > index && nums[i] == nums[i - 1])

---------------------------------

Day 03 Takeaway

Not every problem is tough if it looks big.

Break:
Problem
→ Pattern
→ Smaller Problem
→ Solution

=================================================
*/