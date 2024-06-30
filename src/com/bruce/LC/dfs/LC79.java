package com.bruce.LC.dfs;

public class LC79 {
    boolean[][] results;

    public boolean exist(char[][] board, String word) {
        results = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (dfs(board, i, j, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, int index, String word) {
        if (index == word.length()) {
            return true;
        }

        // if last board is true, do not back search again
        if (i >= board.length || j >= board[0].length || i < 0 || j < 0
                || word.charAt(index) != board[i][j]
                || results[i][j]) {
            return false;
        }

        results[i][j] = true;

        boolean ans = dfs(board, i + 1, j, index + 1, word)
                || dfs(board, i - 1, j, index + 1, word)
                || dfs(board, i, j + 1, index + 1, word)
                || dfs(board, i, j - 1, index + 1, word);

        if (ans) {
            return true;
        }
        results[i][j] = false;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new LC79().exist(new char[][]{
                {'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}
        }, "ABCCED"));
    }
}
