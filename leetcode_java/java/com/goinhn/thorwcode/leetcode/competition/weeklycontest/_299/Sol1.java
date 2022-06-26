package com.goinhn.thorwcode.leetcode.competition.weeklycontest._299;

/**
 * @author goinhn
 * @date 2022/6/26
 */
public class Sol1 {

    /**
     * time:O()
     * space:O()
     */
    private static class Solution1 {

        public boolean checkXMatrix(int[][] grid) {
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (i == j || i + j == grid.length - 1) {
                        if (grid[i][j] == 0) {
                            return false;
                        }
                    } else {
                        if (grid[i][j] != 0) {
                            return false;
                        }
                    }
                }
            }

            return true;
        }

    }

}
