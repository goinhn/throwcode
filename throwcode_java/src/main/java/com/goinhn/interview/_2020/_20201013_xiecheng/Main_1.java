package com.goinhn.interview._2020._20201013_xiecheng;

import java.util.Scanner;

/**
 * 携程笔试
 */
public class Main_1 {

    private static final Scanner scanner = new Scanner(System.in);

    private static int count;
    private static int x;

    public static void main(String[] args) {
        int m = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        x = scanner.nextInt();
        count = 0;
        getMinCount(m, a, b, c);
        System.out.println(count);


        scanner.close();
    }

    public static void getMinCount(int m, int a, int b, int c) {
        if (m == 0) {
            return;
        }

        int temp = x;
        int cCount = temp % 100 == 0 ? temp / 100 : temp / 100 + 1;
        if (cCount > c) {
            temp = temp - c * 100;
            count += c;
            c = 0;
            int bCount = temp % 50 == 0 ? temp / 50 : temp / 50 + 1;
            if (bCount > b) {
                temp = temp - b * 50;
                count += b;
                b = 0;
                int aCount = temp / 10;
                a -= aCount;
                count += aCount;
                m--;
                getMinCount(m, a, b, c);
            } else {
                b -= bCount;
                int now = bCount * 50 - temp;
                a += now / 10;
                count += bCount;
                m--;
                getMinCount(m, a, b, c);
            }
        } else {
            c -= cCount;
            int now = cCount * 100 - temp;
            b += now / 50;
            a += now % 50 / 10;
            count += cCount;
            m--;
            getMinCount(m, a, b, c);
        }
    }

}

