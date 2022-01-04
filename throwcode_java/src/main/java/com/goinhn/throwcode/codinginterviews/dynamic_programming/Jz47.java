package com.goinhn.throwcode.codinginterviews.dynamic_programming;

/**
 * 47.礼物的最大价值
 *
 * @author goinhn
 * @date 2022/1/3
 */
public class Jz47 {

    /**
     * 动态规划
     * time:O(mn)
     * space:O(mn)
     */
    private static class Solution1 {
        public int maxValue(int[][] grid) {
            int[][] dp = new int[grid.length][grid[0].length];
            dp[0][0] = grid[0][0];
            for (int i = 1; i < grid.length; i++) {
                dp[i][0] = dp[i - 1][0] + grid[i][0];
            }
            for (int i = 1; i < grid[0].length; i++) {
                dp[0][i] = dp[0][i - 1] + grid[0][i];
            }
            for (int i = 1; i < grid.length; i++) {
                for (int j = 1; j < grid[0].length; j++) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                }
            }
            return dp[grid.length - 1][dp[0].length - 1];
        }
    }

    /**
     * 动态规划、进一步压缩空间
     * time:O(mn)
     * space:O(1)
     */
    private static class Solution2 {
        public int maxValue(int[][] grid) {
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (i == 0 && j == 0) {
                        continue;
                    } else if (i == 0) {
                        grid[i][j] += grid[i][j - 1];
                    } else if (j == 0) {
                        grid[i][j] += grid[i - 1][j];
                    } else {
                        grid[i][j] += Math.max(grid[i][j - 1], grid[i - 1][j]);
                    }
                }
            }
            return grid[grid.length - 1][grid[0].length - 1];
        }
    }
}

