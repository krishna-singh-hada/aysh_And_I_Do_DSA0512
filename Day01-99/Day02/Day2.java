import java.util.*;
public class Day2 {

    public static void main(String[] args) {

        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        // Build Prefix Matrix
        int[][] prefix = buildPrefix(matrix);

        System.out.println("Prefix Matrix:");

        for (int[] row : prefix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }

        // LC 304 Style Query
        int rectangleSum =
                sumRegion(prefix, 1, 1, 2, 2);

        System.out.println("\nRectangle Sum = " + rectangleSum);

        // LC 1314 Style Block Sum
        int[][] blockSum =
                matrixBlockSum(matrix, 1);

        System.out.println("\nMatrix Block Sum:");

        for (int[] row : blockSum) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    // Build 2D Prefix Matrix
    public static int[][] buildPrefix(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] prefix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                int top =
                        (i > 0)
                                ? prefix[i - 1][j]
                                : 0;

                int left =
                        (j > 0)
                                ? prefix[i][j - 1]
                                : 0;

                int diagonal =
                        (i > 0 && j > 0)
                                ? prefix[i - 1][j - 1]
                                : 0;

                prefix[i][j] =
                        matrix[i][j]
                                + top
                                + left
                                - diagonal;
            }
        }

        return prefix;
    }

    // LC 304
    public static int sumRegion(
            int[][] prefix,
            int r1,
            int c1,
            int r2,
            int c2) {

        int total = prefix[r2][c2];

        int top =
                (r1 > 0)
                        ? prefix[r1 - 1][c2]
                        : 0;

        int left =
                (c1 > 0)
                        ? prefix[r2][c1 - 1]
                        : 0;

        int overlap =
                (r1 > 0 && c1 > 0)
                        ? prefix[r1 - 1][c1 - 1]
                        : 0;

        return total - top - left + overlap;
    }

    // LC 1314
    public static int[][] matrixBlockSum(
            int[][] mat,
            int k) {

        int rows = mat.length;
        int cols = mat[0].length;

        int[][] prefix = buildPrefix(mat);

        int[][] answer =
                new int[rows][cols];

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                int r1 =
                        Math.max(0, i - k);

                int c1 =
                        Math.max(0, j - k);

                int r2 =
                        Math.min(rows - 1, i + k);

                int c2 =
                        Math.min(cols - 1, j + k);

                answer[i][j] =
                        sumRegion(
                                prefix,
                                r1,
                                c1,
                                r2,
                                c2);
            }
        }

        return answer;
    }
}