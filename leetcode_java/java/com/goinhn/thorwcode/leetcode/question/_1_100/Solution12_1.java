package com.goinhn.thorwcode.leetcode.question._1_100;

import java.util.Scanner;

public class Solution12_1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.println(new Solution12_1().getLuo(num));
    }

    private String getLuo(int num) {
        String result = "";

        int position = 1;
        int temp = num;
        while (temp > 0) {
            temp = temp / 10;
            position *= 10;
        }

        for (int i = position / 10; i >= 1; i /= 10) {
            int yu = num % i;
            num = num/i;
            if (num == 4) {
                switch (i) {
                    case 1:
                        result += "IV";
                        break;
                    case 10:
                        result += "XL";
                        break;
                    case 100:
                        result += "CD";
                        break;
                }
            } else if (num == 9) {
                switch (i) {
                    case 1:
                        result += "IX";
                        break;
                    case 10:
                        result += "XC";
                        break;
                    case 100:
                        result += "CM";
                        break;
                }
            } else {
                if (num >= 5) {
                    result += "V";
                    int ti = num - 5;
                    for (int j = 0; j < ti; j++) {
                        result += "I";
                    }
                } else {
                    for (int j = 0; j < num; j++) {
                        result += "I";
                    }
                }
            }
            num = yu;
        }

        return result;
    }

}
