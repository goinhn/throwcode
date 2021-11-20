package com.goinhn.thorwcode.leetcode.question._1_100;

public class Solution12 {
    public String intToRoman(int num) {
        String result = "";
        int number = 0;

        number = num / 1000;
        if (number > 0) {
            for (int i = 0; i < number; i++) {
                result += "M";
            }
        }

        num %= 1000;
        number = num / 100;
        if (number >= 5) {
            if (number == 9) {
                result += "CM";
            } else {
                result += "D";
                for (int i = 0; i < number - 5; i++) {
                    result += "C";
                }
            }
        } else {
            if (number == 4) {
                result += "CD";
            } else {
                for (int i = 0; i < number; i++) {
                    result += "C";
                }
            }
        }

        num %= 100;
        number = num / 10;
        if (number >= 5) {
            if (number == 9) {
                // result = result.substring(0, result.length() - 1);
                result += "XC";
            } else {
                result += "L";
                for (int i = 0; i < number - 5; i++) {
                    result += "X";
                }
            }
        } else {
            if (number == 4) {
                result += "XL";
            } else {
                for (int i = 0; i < number; i++) {
                    result += "X";
                }
            }
        }

        num %= 10;
        number = num;
        if (number >= 5) {
            if (number == 9) {
                // result = result.substring(0, result.length() - 1);
                result += "IX";
            } else {
                result += "V";
                for (int i = 0; i < number - 5; i++) {
                    result += "I";
                }
            }
        } else {
            if (number == 4) {
                result += "IV";
            } else {
                for (int i = 0; i < number; i++) {
                    result += "I";
                }
            }
        }

        return result;

    }
}