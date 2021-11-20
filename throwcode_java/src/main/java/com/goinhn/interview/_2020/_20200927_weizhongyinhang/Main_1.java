package com.goinhn.interview._2020._20200927_weizhongyinhang;

import java.util.Arrays;
import java.util.Scanner;

public class Main_1 {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < q; i++) {
            int target = scanner.nextInt();
            stringBuilder.append(getNum(arr, target) + "\n");
        }
        System.out.println(stringBuilder);

        scanner.close();
    }

    public static int getNum(int[] arr, int target) {
        int cha = Integer.MAX_VALUE;
        int num = -1;
        for (int i = 0; i < arr.length; i++) {
            int temp = Math.abs(arr[i] - target);
            if (temp < cha) {
                cha = temp;
                num = arr[i];
            }

            if (arr[i] > target && temp >= cha) {
                break;
            }

            if (cha == 0) {
                break;
            }
        }

        return num;
    }


}