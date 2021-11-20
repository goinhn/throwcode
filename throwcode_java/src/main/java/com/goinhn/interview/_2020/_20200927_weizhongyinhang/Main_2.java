package com.goinhn.interview._2020._20200927_weizhongyinhang;

import java.util.Scanner;

public class Main_2 {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int z = scanner.nextInt();
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int count = scanner.nextInt();
        for (int i = 0; i < count; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int[] result = getNew(a, b, n, m, x, y, z);
            System.out.println(result[0] + " " + result[1]);
        }
        scanner.close();
    }

    public static int[] getNew(int a, int b, int n, int m, int x, int y, int z) {
        for (int i = 0; i < x; i++) {
            int temp = n;
            n = m;
            m = temp;
            temp = a;
            a = b;
            b = m - temp + 1;
        }

        for (int i = 0; i < y; i++) {
            b = m - b + 1;
        }

        for (int i = 0; i < z; i++) {
            int temp = n;
            n = m;
            m = temp;
            temp = b;
            b = a;
            a = n - temp + 1;
        }

        return new int[]{a, b};
    }


}