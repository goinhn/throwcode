package com.goinhn.interview._2020._20201013_hengtai;

import java.util.Scanner;

/**
 * <p>
 * 衡泰软件
 * <p>
 * 输入一个资金的数字，输出资金按照不同等级划分需要交的利率
 * <10: 10%
 * 10~20: 7.5%
 * 20~40: 5%
 * 40~60: 2.5%
 * 60~80: 1.5%
 * >80%: 1%
 * </p>
 *
 * @author goinhn
 * @date 2020-10-14T00:24:07
 */
public class Main_1 {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        double num = Double.parseDouble(scanner.nextLine());
        System.out.println(getNum(num));
    }

    public static double getNum(double num) {
        double result = 0.0;
        if (num > 80) {
            result += (num - 80) * 0.01;
            num = 80;
        }

        if (num > 60) {
            result += (num - 60) * 0.015;
            num = 60;
        }

        if (num > 40) {
            result += (num - 40) * 0.025;
            num = 40;
        }

        if (num > 20) {
            result += (num - 20) * 0.05;
            num = 20;
        }

        if (num > 10) {
            result += (num - 10) * 0.075;
            num = 10;
        }

        result += num * 0.1;

        return result;
    }

}
