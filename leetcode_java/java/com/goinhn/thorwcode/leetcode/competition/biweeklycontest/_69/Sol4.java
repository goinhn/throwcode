package com.goinhn.thorwcode.leetcode.competition.biweeklycontest._69;


/**
 * @author goinhn
 * @date 2022/01/08
 */
public class Sol4 {

    private static class Solution1 {
        public boolean possibleToStamp(int[][] grid, int stampHeight, int stampWidth) {
            if (stampHeight > grid.length || stampWidth > grid[0].length) {
                return false;
            }

            if (isAllHave(grid)) {
                return true;
            }

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if ((grid[i][j] == 0 || grid[i][j] == 2) && isHasBarrier(grid, i, j, i + stampHeight,
                            j + stampWidth)) {
                        fill(grid, i, j, i + stampHeight, j + stampWidth);
                    }
                }
            }

            return isAllSet(grid);
        }

        private boolean isHasBarrier(int[][] grid, int i, int j, int innerHeight, int innerWidth) {
            if (innerHeight > grid.length || innerWidth > grid[0].length) {
                return false;
            }
            for (int iTemp = i; iTemp < innerHeight; iTemp++) {
                for (int jTemp = j; jTemp < innerWidth; jTemp++) {
                    if (grid[iTemp][jTemp] == 1) {
                        return false;
                    }
                }
            }
            return true;
        }

        private void fill(int[][] grid, int i, int j, int innerHeight, int innerWidth) {
            if (innerHeight > grid.length || innerWidth > grid[0].length) {
                return;
            }
            for (int iTemp = i; iTemp < innerHeight; iTemp++) {
                for (int jTemp = j; jTemp < innerWidth; jTemp++) {
                    grid[iTemp][jTemp] = 2;
                }
            }
        }

        private boolean isAllSet(int[][] grid) {
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 0) {
                        return false;
                    }
                }
            }
            return true;
        }

        private boolean isAllHave(int[][] grid) {
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] != 1) {
                        return false;
                    }
                }
            }
            return true;
        }

        public static void main(String[] args) {
            System.out.println(new Solution1().possibleToStamp(new int[][]{{1,0,0,0},{1,0,0,0},{1,0,0,0},{1,0,0,0}},
                    4, 3));
        }
    }
}
