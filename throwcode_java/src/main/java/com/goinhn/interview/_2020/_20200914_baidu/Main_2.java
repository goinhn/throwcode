package com.goinhn.interview._2020._20200914_baidu;

import java.util.Scanner;

public class Main_2 {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int size = Integer.parseInt(scanner.nextLine());
        int[][] arr = new int[size][size];


        for (int i = 0; i < size; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < size; j++) {
                arr[i][j] = line.charAt(j) - 48;
            }
        }

        arr = blackWin(arr, size);

        for (int[] ints : arr) {
            String line = "";
            for (int anInt : ints) {
                line += anInt;
            }
            System.out.println(line);
        }

        scanner.close();
    }

    public static int[][] blackWin(int[][] arr, int size) {
        for (int j = 0; j < size - 1; j++) {
            changeBorderWhite(arr, 0, j, size);
        }

        for (int i = 0; i < size - 1; i++) {
            changeBorderWhite(arr, i, size - 1, size);
        }

        for (int j = size - 1; j > 0; j--) {
            changeBorderWhite(arr, size - 1, j, size);
        }

        for (int i = size - 1; i > 0; i--) {
            changeBorderWhite(arr, i, 0, size);
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (arr[i][j] == 0) {
                    arr[i][j] = 1;
                } else if (arr[i][j] == 2) {
                    arr[i][j] = 0;
                }
            }
        }

        return arr;
    }

    public static int[][] changeBorderWhite(int[][] arr, int i, int j, int size) {
        if (arr[i][j] == 1 || arr[i][j] == 2) {
            return arr;
        }

        arr[i][j] = 2;

        if (j - 1 > 0) {
            changeBorderWhite(arr, i, j - 1, size);
        }

        if (j + 1 < size) {
            changeBorderWhite(arr, i, j + 1, size);
        }

        if (i - 1 > 0) {
            changeBorderWhite(arr, i - 1, j, size);
        }

        if (i + 1 < size) {
            changeBorderWhite(arr, i + 1, j, size);
        }

        return arr;
    }


}
