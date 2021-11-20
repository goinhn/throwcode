package com.goinhn.interview._2020._20200914_langchao;

import java.util.Scanner;

public class Main_1 {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int count = scanner.nextInt();
        int[] arr = new int[count];
        for (int i = 0; i < count; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println(changeStone(arr));

        scanner.close();
    }

    public static int changeStone(int[] arr) {
        int nowMax = 0;
        int stoneMax = 0;
        for (int i = 0; i < arr.length; i++) {
            nowMax = 1;
            int temp = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[i] && arr[j] > temp) {
                    temp = arr[j];
                    nowMax++;
                }
            }
            stoneMax = Math.max(nowMax, stoneMax);
        }

        return arr.length - stoneMax;
    }


}