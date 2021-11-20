package com.goinhn.interview._2020._20200920_meituan;

import java.util.Scanner;

public class Main_1 {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int left = scanner.nextInt();
        int right = scanner.nextInt();

        System.out.println(count(left, right));
        scanner.close();
    }

    public static int count(int left, int right) {
        int count = 0;
        int[] arr = new int[6];
        for (int i = left; i < right + 1; i++) {
            arr[0] = i / 100000;
            arr[1] = (i / 10000) % 10;
            arr[2] = (i / 1000) % 10;
            arr[3] = (i / 100) % 10;
            arr[4] = (i / 10) % 10;
            arr[5] = i % 10;

            if (arr[0] == 0) {
                continue;
            }

            if (isDouble(arr)) {
                continue;
            }

            if (arr[0] * 10 + arr[1] + arr[2] * 10 + arr[3] == arr[4] * 10 + arr[5]) {
                count++;
            }
        }

        return count;
    }

    public static boolean isDouble(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i == j) {
                    continue;
                }
                if (arr[i] == arr[j]) {
                    return true;
                }
            }
        }

        return false;
    }

}