package com.goinhn.sworddirectoffer;

import java.util.ArrayList;

/**
 * <p>
 * 顺时针打印矩阵
 * <p>
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * </p>
 *
 * @author goinhn
 * @date 2020-12-09T19:53:08
 */
public class JZ19 {

    public ArrayList<Integer> printMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return null;
        }

        ArrayList<Integer> list = new ArrayList<>();
        int top = 0, bottom = matrix.length - 1, left = 0, right = matrix[0].length - 1;
        while (top <= bottom && left <= right) {
            printBorder(matrix, top, right, bottom, left, list);
            top++;
            bottom--;
            left++;
            right--;
        }

        return list;
    }


    /**
     * 顺时针循环打印
     * @param matrix
     * @param top
     * @param right
     * @param bottom
     * @param left
     * @param list
     */
    public void printBorder(int[][] matrix, int top, int right, int bottom, int left, ArrayList<Integer> list) {
        if (top == bottom && left == right) {
            list.add(matrix[top][left]);
            return;
        }

        if(top == bottom) {
            for(int i = left; i < right + 1; i++) {
                list.add(matrix[top][i]);
            }
            return;
        }

        if(left == right) {
            for(int i = top; i < bottom + 1; i++) {
                list.add(matrix[i][left]);
            }
            return;
        }

        for (int i = left; i < right; i++) {
            list.add(matrix[top][i]);
        }

        for (int i = top; i < bottom; i++) {
            list.add(matrix[i][right]);
        }

        for (int i = right; i > left; i--) {
            list.add(matrix[bottom][i]);
        }

        for (int i = bottom; i > top; i--) {
            list.add(matrix[i][left]);
        }
    }

}
