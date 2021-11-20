package com.goinhn.algorithm.datastructure.linertable;

/**
 * <p>
 * 在行列都排好序的矩阵中找数
 * <p>
 * 给定一个有N*M的整型矩阵matrix和一个整数K，matrix的每一行和每一列都是排好序的。实现一个函数，判断K是否在matrix中。
 * <p>
 * 例如：
 * 0 1 2 5
 * 2 3 4 7
 * 4 4 4 8
 * 5 7 7 9
 * 如果K为7，返回true；如果K为6，返回false。
 * 时间复杂度为O(N+M)，额外空间复杂度为O(1)。
 * </p>
 *
 * @author goinhn
 * @date 2020-08-28T11:42:01
 */
public class FindNumInSortedMatrix {

    /**
     * @param matrix
     * @param num
     * @return
     */
    public static boolean findNumInSortedMatrix(int[][] matrix, int num) {
        int x = 0;
        int y = matrix[0].length - 1;

        while (x <= matrix.length - 1 && y >= 0) {
            if (matrix[x][y] > num) {
                y--;
            } else if (matrix[x][y] < num) {
                x++;
            } else {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

    }

}
