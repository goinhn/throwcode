package com.goinhn.interview._2020._20200407_netease;

import java.util.Scanner;

public class Main_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lineNumber = scanner.nextInt();
        Long[] array = new Long[lineNumber];
        for (int i = 0; i < lineNumber; i++) {
            array[i] = scanner.nextLong();
        }

        System.out.println(new Main_1().max(array));
    }

    private Long max(Long[] array) {
        Long result = 1L;
        Long[] temp = new Long[array.length - 1];
        for (int i = 0; i < array.length - 1; i++) {
            Long number = array[i + 1] - array[i];
            if (number <= 0) {
                result = -1L;
                break;
            } else {
                temp[i] = number;
            }
        }
        if (result == -1L) {
            return result;
        } else {
            result = temp[0];
            for (int i = 0; i < temp.length; i++) {
                result = circle(result, temp[i]);
            }
            return result;
        }

    }

    private Long circle(Long a, Long b) {
        if (b == 0) {
            return a;
        }
        return a % b == 0 ? b : circle(b, a % b);
    }

}

