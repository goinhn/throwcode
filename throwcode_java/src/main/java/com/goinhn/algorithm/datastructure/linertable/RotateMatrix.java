package com.goinhn.algorithm.datastructure.linertable;

/**
 * <p>
 * 旋转正方形矩阵
 * <p>
 * 给定一个整型正方形矩阵matrix，请把该矩阵调整成逆时针旋转90度的样子。
 * <p>
 * 额外空间复杂度为O(1)。
 * </p>
 *
 * @author goinhn
 * @date 2020-08-27T18:20:08
 */
public class RotateMatrix {

    /**
     * @param matrix
     */
    public static void rotate(int[][] matrix) {
        int tX = 0;
        int tY = 0;
        int bX = matrix.length - 1;
        int bY = matrix[0].length - 1;
        while (tX < bX && tY < bY) {
            rotateEdge(matrix, tX++, tY++, bX--, bY--);
        }
    }

    /**
     * 依此按照每次的外环边进行打印
     *
     * @param matrix
     * @param tX
     * @param tY
     * @param bX
     * @param bY
     */
    public static void rotateEdge(int[][] matrix, int tX, int tY, int bX, int bY) {
        int times = bY - tY;
        for (int i = 0; i < times; i++) {
            int temp = matrix[tX][tY + i];
            matrix[tX][tY + i] = matrix[tX + i][bY];
            matrix[tX + i][bY] = matrix[bX][bY - i];
            matrix[bX][bY - i] = matrix[bX - i][tY];
            matrix[bX - i][tY] = temp;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        rotate(matrix);

        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

}
