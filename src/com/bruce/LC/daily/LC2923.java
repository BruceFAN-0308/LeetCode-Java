package com.bruce.LC.daily;

/**
 * @description:
 * @author: Luoxin Fan
 * @create: 2024-04-12 11:01
 **/
public class LC2923 {

    public int findChampion(int[][] grid) {


        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1 && i != j) {
                    return i;
                }
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        int[][] grid = {{0, 0, 1}, {1, 0, 1}, {0, 0, 0}};
        System.out.println(new LC2923().findChampion(grid));
    }
}
