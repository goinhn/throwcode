package com.goinhn.interview._2020._20200924_qunaer;

import java.util.Scanner;

public class Main_1 {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        System.out.println(getPeople(m, n));

        scanner.close();
    }

    public static int getPeople(int m, int n) {
        if (m < 1 || n < 1) {
            return 0;
        }

        if (m < n) {
            return 1;
        }

        int result = 1;
        for (int i = 1; i < n + 1; i++) {
            result = result * (m - i + 1) / i;
        }

        return result;
    }


}