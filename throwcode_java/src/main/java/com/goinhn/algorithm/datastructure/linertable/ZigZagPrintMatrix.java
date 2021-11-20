package com.goinhn.algorithm.datastructure.linertable;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 之字型打印矩阵
 * </p>
 *
 * @author goinhn
 * @date 2020-08-28T10:26:35
 */
public class ZigZagPrintMatrix {

    /**
     * @param matrix
     * @return
     */
    public static List<Integer> printZigZagMatrix(int[][] matrix) {
        int tX = 0;
        int tY = 0;
        int bX = 0;
        int bY = 0;
        int endX = matrix.length - 1;
        int endY = matrix[0].length - 1;
        boolean fromUp = false;
        List<Integer> list = new ArrayList<>();
        while (tX <= endX || bY <= endY) {
            printLevel(matrix, tX, tY, bX, bY, fromUp, list);
            // 条件判断依赖于别的数的话，当前数要先进行判断，防止别的数被篡改导致判断条件失效
            tX = tY == endY ? tX + 1 : tX;
            tY = tY == endY ? tY : tY + 1;
            bY = bX == endX ? bY + 1 : bY;
            bX = bX == endX ? bX : bX + 1;
            fromUp = !fromUp;
        }

        return list;
    }

    /**
     * 按照斜角的方式进行打印
     *
     * @param matrix
     * @param tX
     * @param tY
     * @param bX
     * @param bY
     * @param order
     * @param list
     * @return
     */
    public static List<Integer> printLevel(int[][] matrix, int tX, int tY, int bX, int bY, boolean order, List<Integer> list) {
        // 从右上角打印到左下角
        if (order) {
            while (tX <= bX && tY >= bY) {
                list.add(matrix[tX++][tY--]);
            }
            // 从左下角打印到右上角
        } else {
            while (bX >= tX && bY <= tY) {
                list.add(matrix[bX--][bY++]);
            }
        }

        return list;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        List<Integer> list = printZigZagMatrix(matrix);

        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

}
