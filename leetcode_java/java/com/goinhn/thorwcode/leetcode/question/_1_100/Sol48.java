package com.goinhn.thorwcode.leetcode.question._1_100;

/**
 * 48.旋转图像
 *
 * @author goinhn
 * @date 2022/7/14
 */
public class Sol48 {

    /**
     * 模拟
     * time:O(n^2)
     * space:O(1)
     */
    private static class Solution1 {

        public void rotate(int[][] matrix) {
            int side = 0;
            int len = matrix.length;
            while (side < matrix.length / 2) {

                int lenMid = len - side - 1;
                for (int i = side; i < lenMid; i++) {
                    int lenMidI = len - i - 1;
                    int temp = matrix[side][i];
                    matrix[side][i] = matrix[lenMidI][side];
                    matrix[lenMidI][side] = matrix[lenMid][lenMidI];
                    matrix[lenMid][lenMidI] = matrix[i][lenMid];
                    matrix[i][lenMid] = temp;
                }

                side++;
            }
        }

    }

    /**
     * 先水平翻转，后对称轴翻转
     * time:O(n^2)
     * space:O(1)
     */
    private static class Solution2 {

        public void rotate(int[][] matrix) {
            int n = matrix.length;

            // 水平翻转
            for (int i = 0; i < n / 2; ++i) {
                for (int j = 0; j < n; ++j) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[n - i - 1][j];
                    matrix[n - i - 1][j] = temp;
                }
            }

            // 主对角线翻转
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < i; ++j) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }

        }

    }

}
