package com.bruce.LC.dfs;

public class LC200 {

    int ans;

    public int numIslands(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '0') {
                    continue;
                }

                if (dfs(grid, i, j)) {
                    ans++;
                }
            }
        }
        return ans;
    }

    private boolean dfs(char[][] grid, int i, int j) {
        if (i < 0
                || j < 0
                || i >= grid.length
                || j >= grid[0].length
                || grid[i][j] == '0') {
            return true;
        }

        // mark is '0', which means this '1' is visited.
        grid[i][j] = '0';
        return dfs(grid, i + 1, j)
                && dfs(grid, i - 1, j)
                && dfs(grid, i, j + 1)
                && dfs(grid, i, j - 1);
    }

    public static void main(String[] args) {
        System.out.println(new LC200().numIslands(new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}}
        ));
    }
}
