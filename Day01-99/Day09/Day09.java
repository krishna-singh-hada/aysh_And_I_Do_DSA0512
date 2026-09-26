import java.util.*;


public class Day09 {

    // 1. Minimum Queen Moves
    static int minQueenMoves(int[] source, int[] target) {

        int sr = source[0];
        int sc = source[1];

        int tr = target[0];
        int tc = target[1];

        if (sr == tr && sc == tc) return 0;

        if (sr == tr ||
            sc == tc ||
            Math.abs(sr - tr) == Math.abs(sc - tc)) {
            return 1;
        }

        return 2;
    }

    // 2. Fruit Into Baskets
    static int totalFruit(int[] fruits) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < fruits.length; right++) {

            map.put(fruits[right],
                    map.getOrDefault(fruits[right], 0) + 1);

            while (map.size() > 2) {

                map.put(fruits[left],
                        map.get(fruits[left]) - 1);

                if (map.get(fruits[left]) == 0) {
                    map.remove(fruits[left]);
                }

                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    // 3. Longest Subarray Of 1s After Deleting One Element
    static int longestSubarray(int[] nums) {

        int left = 0;
        int zeroCount = 0;
        int maxLen = 0;

        for (int right = 0; right < nums.length; right++) {

            if (nums[right] == 0) {
                zeroCount++;
            }

            while (zeroCount > 1) {

                if (nums[left] == 0) {
                    zeroCount--;
                }

                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen - 1;
    }

    // 4. Max Consecutive Ones III
    static int longestOnes(int[] nums, int k) {

        int left = 0;
        int zeroCount = 0;
        int maxLen = 0;

        for (int right = 0; right < nums.length; right++) {

            if (nums[right] == 0) {
                zeroCount++;
            }

            while (zeroCount > k) {

                if (nums[left] == 0) {
                    zeroCount--;
                }

                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {

        System.out.println(
            minQueenMoves(
                new int[]{1, 1},
                new int[]{8, 8}
            )
        );

        System.out.println(
            totalFruit(
                new int[]{1, 2, 1}
            )
        );

        System.out.println(
            longestSubarray(
                new int[]{1, 1, 0, 1}
            )
        );

        System.out.println(
            longestOnes(
                new int[]{1,1,1,0,0,0,1,1,1,1,0},
                2
            )
        );
    }
}