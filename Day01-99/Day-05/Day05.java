
// Implementation: day5.java
import java.util.*;
class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (dfs(board, word, row, col, 0))
                    return true;
            }
        }

        return false;
    }

    public boolean dfs(char[][] board, String word,
                       int row, int col, int index) {

        if (index == word.length())
            return true;

        if (row < 0 || col < 0 ||
            row >= board.length || col >= board[0].length ||
            board[row][col] != word.charAt(index))
            return false;

        char temp = board[row][col];
        board[row][col] = '#';

        boolean found =
            dfs(board, word, row + 1, col, index + 1) ||
            dfs(board, word, row, col + 1, index + 1) ||
            dfs(board, word, row - 1, col, index + 1) ||
            dfs(board, word, row, col - 1, index + 1);

        board[row][col] = temp;

        return found;
    }


     List<String> ans = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backTrack("", 0, 0, n);
        return ans;
    }

    private void backTrack(String s, int open, int close, int n) {
        if (s.length() == n * 2) {
            ans.add(s);
            return;
        }

        if (open < n) {
            backTrack(s + "(", open + 1, close, n);
        }

        if (close < open) {
            backTrack(s + ")", open, close + 1, n);
        }
    }
}

