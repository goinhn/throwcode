package com.goinhn.interview._2020._20200924_qunaer;

import java.util.Scanner;

public class Main_2 {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int length = Integer.parseInt(scanner.nextLine());
        String a = scanner.nextLine().replace(" ", "");
        String b = scanner.nextLine().replace(" ", "");

        String resultStr = getMaxSubStr(a, b);
        int count = resultStr.length() / 2;
        resultStr = resultStr.substring(0, resultStr.length() - 1);
        System.out.println(count + "(" + resultStr + ")");

        scanner.close();
    }

    public static String getMaxSubStr(String a, String b) {
        int aLen = a.length();
        int bLen = b.length();
        int[][] dp = new int[aLen + 1][bLen + 1];
        int[][] flag = new int[aLen + 1][bLen + 1];

        for (int i = 1; i < aLen + 1; i++) {
            for (int j = 1; j < bLen + 1; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }

                if (dp[i][j] == dp[i - 1][j]) {
                    flag[i][j] = -1;
                } else if (dp[i][j] == dp[i - 1][j - 1]) {
                    flag[i][j] = -2;
                } else {
                    flag[i][j] = -3;
                }
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        int i = aLen;
        int j = bLen;
        while (i > 0 && j > 0) {
            char nowChar = a.charAt(i - 1);
            int nowLen = dp[i][j];
            int flagNow = flag[i][j];
            if (flagNow == -1) {
                i--;
            } else if (flagNow == -2) {
                i--;
                j--;
            } else {
                j--;
            }
            if (nowLen > dp[i][j]) {
                stringBuilder.append(nowChar).append(" ");
            }
        }

        return stringBuilder.toString();
    }

}




