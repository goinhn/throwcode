package com.goinhn.interview._2020._20201009_haier;

import java.util.Scanner;

/**
 * <p>
 * 输出二维数组中各行的数组的最大值
 * </p>
 *
 * @author goinhn
 * @date 2020-10-09T14:13:28
 */
public class Main_2 {

    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] arr = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0;i < arr.length; i++) {
            int max = getMax(arr[i]);
            stringBuilder.append("_").append(max);
        }

        System.out.println(stringBuilder.substring(1));
    }


    public static int getMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }

        return max;
    }


}
