package com.goinhn.algorithm.datastructure.linertable;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 转圈打印矩阵
 * <p>
 * 给定一个整型矩阵matrix，请按照转圈的方式打印它。
 * <p>
 * 例如： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * <p>
 * 打印结果为：1，2，3，4，8，12，16，15，14，13，9，5，6，7，11，10
 * <p>
 * 要求：额外空间复杂度为O(1)。
 * </p>
 *
 * @author goinhn
 * @date 2020-08-26T23:24:36
 */
public class PrintMatrixSpiralOrder {

    /**
     * @param matrix
     * @return
     */
    public static List<Integer> printMatrixSpiralOrder(int[][] matrix) {
        int tX = 0;
        int tY = 0;
        int bX = matrix.length - 1;
        int bY = matrix[0].length - 1;
        List<Integer> list = new ArrayList<>();
        while (tX <= bX && bX <= bY) {
            list = printEdge(matrix, tX++, tY++, bX--, bY--, list);
        }

        return list;
    }

    /**
     * 按照一圈一圈的方式打印每一圈的边界
     *
     * @param matrix
     * @param tX
     * @param tY
     * @param bX
     * @param bY
     * @param list
     * @return
     */
    public static List<Integer> printEdge(int[][] matrix, int tX, int tY, int bX, int bY, List<Integer> list) {
        if (tX == bX) {
            while (tY != bY) {
                list.add(matrix[tX][tY]);
                tY++;
            }
        } else if (tY == bY) {
            while (tX != bX) {
                list.add(matrix[tX][tY]);
                tX++;
            }
        } else {
            int curTX = tX;
            int curTY = tY;
            while (curTY != bY) {
                list.add(matrix[curTX][curTY]);
                curTY++;
            }
            while (curTX != bX) {
                list.add(matrix[curTX][curTY]);
                curTX++;
            }
            while (curTY != tY) {
                list.add(matrix[curTX][curTY]);
                curTY--;
            }
            while (curTX != tX) {
                list.add(matrix[curTX][curTY]);
                curTX--;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        List<Integer> list = printMatrixSpiralOrder(matrix);

        for (Integer integer : list) {
            System.out.println(integer);
        }

    }

}
