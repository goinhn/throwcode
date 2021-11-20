package com.goinhn.interview._2020._20200924_shuiyou;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 求解数独
 */
public class Main_1 {

    private static int[][] result;

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[][] arr = new int[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        getResult(arr);

        if (result != null) {
            for (int[] ints : result) {
                for (int anInt : ints) {
                    System.out.print(anInt + " ");
                }
                System.out.println();
            }
        } else {
            for (int[] ints : arr) {
                for (int anInt : ints) {
                    System.out.print(anInt + " ");
                }
                System.out.println();
            }
        }

        scanner.close();
    }

    public static void getResult(int[][] arr) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (arr[i][j] == 0) {
                    for (int x = 1; x < 10; x++) {
                        arr[i][j] = x;
                        if (isSudu(arr)) {
                            result = arr;
                            return;
                        } else {
                            getResult(arr);
                        }
                    }
                }
            }
        }

    }

    public static boolean isSudu(int[][] arr) {
        for (int i = 0; i < 9; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (set.contains(arr[i][j])) {
                    return false;
                } else {
                    set.add(arr[i][j]);
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (set.contains(arr[j][i])) {
                    return false;
                } else {
                    set.add(arr[j][i]);
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                int x = (i / 3) * 3 + j / 3;
                int y = (i % 3) * 3 + j % 3;
                if (set.contains(arr[x][y])) {
                    return false;
                } else {
                    set.add(arr[x][y]);
                }
            }
        }

        return true;
    }

}