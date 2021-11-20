package com.goinhn.niuke.huawei.test1088888;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *华为研发工程师笔试题
 *
 * 写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。（多组同时输入 ）
 *
 *
 * 输入描述:
 * 输入一个十六进制的数值字符串。
 *
 *
 * 输出描述:
 * 输出该数值的十进制字符串。
 *
 *
 * 输入例子1:
 * 0xA
 *
 * 输出例子1:
 * 10
 */
public class Main_03 {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (scanner.hasNextLine()) {
            String strX = scanner.nextLine();
            strX = strX.substring(2);
            System.out.println(new Main_03().toChange(strX));
        }
    }

    private int toChange(String str) {
        int result = 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put('A', 10);
        map.put('B', 11);
        map.put('C', 12);
        map.put('D', 13);
        map.put('E', 14);
        map.put('F', 15);
        for (int i = str.length() - 1; i >= 0; i--) {
            int lo = str.length() - i;
            if (map.keySet().contains(str.charAt(i))) {
                int temp = map.get(str.charAt(i));
                for (int j = 0; j < lo - 1; j++) {
                    temp *= 16;
                }
                result += temp;
            } else {
                int temp = str.charAt(i) - '0';
                for (int j = 0; j < lo - 1; j++) {
                    temp *= 16;
                }
                result += temp;
            }
        }

        return result;
    }

}
