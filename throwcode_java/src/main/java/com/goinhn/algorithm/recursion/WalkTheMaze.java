package com.goinhn.algorithm.recursion;

import java.util.Scanner;

/**
 * <p>
 * 走迷宫的递归回溯算法
 * </p>
 *
 * @author goinhn
 * @date 2020-12-16T22:46:06
 */
public class  WalkTheMaze {

    /*
        0 0 1 0 0 0 1 0 0 1
        0 1 1 0 0 0 1 0 1 0
        0 0 1 0 1 1 0 1 0 1
        0 1 1 1 0 0 1 0 0 1
        0 0 0 1 0 0 0 0 0 0
        0 1 0 0 0 1 0 1 0 1
        0 1 1 1 1 0 0 1 0 0
        1 1 0 0 0 1 0 1 0 1
        1 1 0 0 0 0 0 0 0 1
        1 1 0 0 0 1 0 1 0 0
     */


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int maxRow, maxCol;
        System.out.println("请输入行数：");
        maxRow = scanner.nextInt();
        System.out.println("请输入列数：");
        maxCol = scanner.nextInt();
        System.out.println("请输入地图：");
        int[][] array = new int[maxRow][maxCol];
        for (int i = 0; i < maxRow; i++) {
            for (int j = 0; j < maxCol; j++) {
                array[i][j] = scanner.nextInt();
            }
        }

        Long start = System.currentTimeMillis();
        WalkTheMaze walkTheMaze = new WalkTheMaze();
        walkTheMaze.stepCheck(0, 0, array, maxRow, maxCol);
        Long end = System.currentTimeMillis();

        System.out.println("耗时：" + (end - start) + "ms");
    }

    /**
     * 递归回溯尝试可行的路径
     * 走过的路使用2进行标记
     *
     * @param i
     * @param j
     * @param array
     * @param maxRow
     * @param maxCol
     */
    private void stepCheck(int i, int j, int[][] array, int maxRow, int maxCol) {
//        递归出口(如果到达右下角出口)
        if (i == maxRow - 1 && j == maxCol - 1) {
            print(array, maxRow, maxCol);
            return;
        }

//        向右走
        if (canMove(i, j, i, j + 1, array, maxRow, maxCol)) {
//            已走过的点置标志位2
            array[i][j] = 2;
//            递归调用下一个位置，从下一个点继续寻路
            stepCheck(i, j + 1, array, maxRow, maxCol);
//            当前路径都不可行，则回溯恢复现场
            array[i][j] = 0;
        }

//        向左走
        if (canMove(i, j, i, j - 1, array, maxRow, maxCol)) {
            array[i][j] = 2;
            stepCheck(i, j - 1, array, maxRow, maxCol);
            array[i][j] = 0;
        }

//        向下走
        if (canMove(i, j, i + 1, j, array, maxRow, maxCol)) {
            array[i][j] = 2;
            stepCheck(i + 1, j, array, maxRow, maxCol);
            array[i][j] = 0;
        }

//        向上走
        if (canMove(i, j, i - 1, j, array, maxRow, maxCol)) {
            array[i][j] = 2;
            stepCheck(i - 1, j, array, maxRow, maxCol);
            array[i][j] = 0;
        }
    }


    /**
     * 判断[i,j]-->[targetI,targetJ]是否可行
     *
     * @param i
     * @param j
     * @param targetI
     * @param targetJ
     * @param array
     * @param maxRow
     * @param maxCol
     * @return boolean 可否通过
     */
    private boolean canMove(int i, int j, int targetI, int targetJ, int[][] array, int maxRow, int maxCol) {
//        System.out.println("从第" + (i + 1) + "行第" + (j + 1) + "列，走到第" + (targetI + 1) + "行第" + (targetJ + 1) + "列");

        if (targetI < 0 || targetJ < 0 || targetI >= maxRow || targetJ >= maxCol) {
//            System.out.println("到达最左边或最右边，失败了");
            return false;
        }

        if (array[targetI][targetJ] == 1) {
//            System.out.println("目标是墙，失败了");
            return false;
        }

//        避免在两个空格间来回走，走过的路径不再走
        if (array[targetI][targetJ] == 2) {
//            System.out.println("走过该位置，失败了");
            return false;
        }

        return true;
    }


    /**
     * 打印可行路径
     *
     * @param array
     * @param maxRow
     * @param maxCol
     */
    private void print(int[][] array, int maxRow, int maxCol) {
        System.out.println("get a solution:");
        for (int i = 0; i < maxRow; i++) {
            for (int j = 0; j < maxCol; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }


}



//0 0 1 0 0 0 1 0 0 1
//        0 1 1 0 0 0 1 0 1 0
//        0 0 1 0 1 1 0 1 0 1
//        0 1 1 1 0 0 1 0 0 1
//        0 0 0 1 0 0 0 0 0 0
//        0 1 0 0 0 1 0 1 0 1
//        0 1 1 1 1 0 0 1 0 0
//        1 1 0 0 0 1 0 1 0 1
//        1 1 0 0 0 0 0 0 0 1
//        1 1 0 0 0 1 0 1 0 0
//
//
//        targetI = i - 1 && targetJ = j || targetI = i + 1 && targetJ = j || targetI = i && targetJ = j - 1 || targetI = i && targetJ = j + 1
//        targetI > 0 && targetI < n && targetJ > 0 && targetJ < n && array[targetI][targetJ] != 1 && array[targetI][targetJ] != 2
