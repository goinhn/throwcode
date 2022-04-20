package com.goinhn.throwcode.codinginterviews.simulation;

/**
 * 29.顺时针打印矩阵
 *
 * @author goinhn
 * @date 2022/4/19
 */
public class Jz29 {

    /**
     * 环型打印
     * time:O(n^2)
     * space:O(1)
     */
    private static class Solution1 {
        public int[] spiralOrder(int[][] matrix) {
            if (null == matrix || matrix.length == 0 || matrix[0].length == 0) {
                return new int[0];
            }

            int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1, x = 0;
            int[] res = new int[(r + 1) * (b + 1)];
            while (true) {
                for (int i = l; i <= r; i++) {
                    res[x++] = matrix[t][i]; // left to right.
                }
                if (++t > b) {
                    break;
                }
                for (int i = t; i <= b; i++) {
                    res[x++] = matrix[i][r]; // top to bottom.
                }
                if (l > --r) {
                    break;
                }
                for (int i = r; i >= l; i--) {
                    res[x++] = matrix[b][i]; // right to left.
                }
                if (t > --b) {
                    break;
                }
                for (int i = b; i >= t; i--) {
                    res[x++] = matrix[i][l]; // bottom to top.
                }
                if (++l > r) {
                    break;
                }
            }
            return res;
        }
    }

}
