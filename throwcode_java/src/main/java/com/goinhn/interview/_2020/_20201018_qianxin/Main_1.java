package com.goinhn.interview._2020._20201018_qianxin;

/**
 * <p>
 * 奇安信
 * <p>
 * 在一个网格中从左上角开始走，右下角是出口，每个点都有一个权值，求出走过的路径中，权值和做大的值
 * </p>
 *
 * @author goinhn
 * @date 2020-10-18T17:22:07
 */
public class Main_1 {

    public static int maxValue(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    matrix[i][j] = matrix[i][j];
                } else if (i == 0) {
                    matrix[i][j] += matrix[i][j - 1];
                } else if (j == 0) {
                    matrix[i][j] += matrix[i - 1][j];
                } else {
                    matrix[i][j] += Math.max(matrix[i - 1][j], matrix[i][j - 1]);
                }
            }
        }

        return matrix[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] now = {
                {2, 3, 1},
                {2, 5, 3},
                {4, 2, 1}
        };

        System.out.println(maxValue(now));
    }

}
