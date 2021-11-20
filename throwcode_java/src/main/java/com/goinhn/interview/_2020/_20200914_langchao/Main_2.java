package com.goinhn.interview._2020._20200914_langchao;

import java.util.Scanner;

public class Main_2 {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] odd = new int[50];
        int[] even = new int[50];
        for (int i = 0; i < 50; i++) {
            odd[i] = 2 * i + 1;
            even[i] = 2 * (i + 1);
        }

        int count = scanner.nextInt();
        for (int i = 0; i < count; i++) {
            int num = scanner.nextInt();
            if (num % 2 == 0) {
                even[num / 2 - 1] = -1;
            } else {
                odd[(num - 1) / 2] = -1;
            }
        }

        int[] maxOdd = maxTree(odd);
        int[] maxEven = maxTree(even);

        if (maxOdd[0] > maxEven[0]) {
            System.out.println(odd[maxOdd[1] - maxOdd[0] + 1] + " " + maxOdd[0]);

        } else {
            System.out.println(even[maxEven[1] - maxEven[0] + 1] + " " + maxEven[0]);
        }

        scanner.close();
    }

    public static int[] maxTree(int[] arr) {
        int nowMax = 0;
        int treeMax = 0;
        int endIndex = -1;

        for (int i = -1; i < arr.length; i++) {
            if (i + 1 < arr.length && arr[i + 1] != -1) {
                nowMax++;
            } else if (nowMax > treeMax) {
                treeMax = nowMax;
                endIndex = i;
                nowMax = 0;
            } else {
                nowMax = 0;
            }
        }

        return new int[]{treeMax, endIndex};
    }

}