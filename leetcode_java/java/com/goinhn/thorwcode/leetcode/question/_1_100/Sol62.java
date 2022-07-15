package com.goinhn.thorwcode.leetcode.question._1_100;

/**
 * 62.不同路径
 *
 * @author goinhn
 * @date 2022/7/15
 */
public class Sol62 {

    /**
     * 回溯
     * 超出时间限制
     * time:O(n!)
     * space:O(n)
     */
    private static class Solution1 {

        private int count;

        public int uniquePaths(int m, int n) {
            count = 0;

            backTrack(m, n, 1, 1);

            return count;
        }

        private void backTrack(int m, int n, int i, int j) {
            if (i >= m && j >= n) {
                count++;
            } else if (i < m && j >= n) {
                backTrack(m, n, i + 1, j);
            } else if (i >= m && j < n) {
                backTrack(m, n, i, j + 1);
            } else {
                backTrack(m, n, i + 1, j);
                backTrack(m, n, i, j + 1);
            }
        }

    }

}
