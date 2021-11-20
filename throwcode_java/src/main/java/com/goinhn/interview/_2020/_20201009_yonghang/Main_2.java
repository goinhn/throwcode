package com.goinhn.interview._2020._20201009_yonghang;

import java.util.Scanner;

/**
 * 统计字符串中字符连续出现的个数，按照出现的顺序
 */
public class Main_2 {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String str = scanner.nextLine();
        str = getNow(str);
        System.out.println(str);
        scanner.close();
    }

    public static String getNow(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }

        if (str.length() == 1) {
            return str + "_1";
        }

        StringBuilder stringBuilder = new StringBuilder();
        char now = str.charAt(0);
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            char temp = str.charAt(i);
            if (now == temp) {
                count++;
            } else {
                stringBuilder.append("_").append(now).append("_").append(count);
                now = temp;
                count = 1;
            }
        }

        stringBuilder.append("_").append(now).append("_").append(count);

        return stringBuilder.substring(1);
    }

}