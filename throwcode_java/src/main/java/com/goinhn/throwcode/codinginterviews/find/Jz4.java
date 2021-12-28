package com.goinhn.throwcode.codinginterviews.find;

/**
 * 4.二维数组中的查找
 *
 * @author goinhn
 * @date 2020-12-05T14:24:12
 */
public class Jz4 {

    /**
     * 线性搜索
     * time:O(n + m)
     * space:O(1)
     */
    private static class Solution1 {
        public boolean findNumberIn2DArray(int[][] matrix, int target) {
            if (matrix == null || matrix.length == 0) {
                return false;
            }
            int x = 0;
            int y = matrix[0].length - 1;
            while (x < matrix.length && y > -1) {
                if (matrix[x][y] < target) {
                    x++;
                } else if (matrix[x][y] > target) {
                    y--;
                } else {
                    return true;
                }
            }
            return false;
        }
    }

}
