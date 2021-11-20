package com.goinhn.interview._2020._20200916_huawei;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main_1 {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] location = scanner.nextLine().split(",");

        System.out.println(result(location));

        scanner.close();
    }

    public static String result(String[] location) {
        List<Integer> list = Arrays.asList(0, 1, 2, 3, 4, 3, 2, 1, 5, 6, 5, 7, 8, 9, 8, 7, 5, 1, 0);

        int temp = -1;
        int index = 0;
        int i;
        for (i = 0; i < location.length && index < list.size(); i++) {
            if (!Character.isDigit(location[i].charAt(0))) {
                return "Collision";
            }

            int num = Integer.parseInt(location[i]);
            if (num == -1 && temp != -1) {
                return "Out of path";
            }

            if (temp == num) {
                continue;
            }

            if (num == list.get(index)) {
                index++;
                temp = num;
            } else {
                return "Bad path";
            }
        }


        return index < list.size() ? "Bad path" : "Success";
    }


}