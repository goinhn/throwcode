package com.goinhn.interview._2020._20200920_meituan;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * <p>
 *
 * </p>
 *
 * @author goinhn
 * @date 2020-09-20T11:45:44
 */
public class Main_5 {
    public static void main(String args[]) {

        try {
            Scanner s = new Scanner(System.in);
            String str = s.next();
            int len = str.length();
            if (len == 6 || len == 7) {
                if (len == 7 && !str.startsWith("#")) {
                    System.out.println("输入不合法");
                    return;
                }
                String regex = "[0-9a-fA-F]{6}$";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(str);
                if (!matcher.find()) {
                    System.out.println("输入不合法");
                    return;
                }
            } else {
                System.out.println("输入不合法");
                return;
            }
            getBinaryString(str);
            // getBinaryString2(str);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Integer.toBinaryString,不足四位的补零
    public static void getBinaryString(String str) {
        int i = 0;
        int len = str.length();
        if (len == 7) i++;

        while (i < len) {
            int num = 0;
            if (str.charAt(i) == 'a' || str.charAt(i) == 'A') {
                num = 10;
            } else if (str.charAt(i) == 'b' || str.charAt(i) == 'B') {
                num = 11;
            } else if (str.charAt(i) == 'c' || str.charAt(i) == 'C') {
                num = 12;
            } else if (str.charAt(i) == 'd' || str.charAt(i) == 'D') {
                num = 13;
            } else if (str.charAt(i) == 'e' || str.charAt(i) == 'E') {
                num = 14;
            } else if (str.charAt(i) == 'f' || str.charAt(i) == 'F') {
                num = 15;
            } else {
                num = str.charAt(i) - '0';
            }
            int currentLenth = 4;
            String binaryString = Integer.toBinaryString(num);
            int cz = currentLenth - binaryString.length();
            StringBuffer stringBuffer = new StringBuffer();
            while (cz != 0) {
                stringBuffer.append("0");
                cz--;
            }
            stringBuffer.append(binaryString);
            System.out.print(stringBuffer.toString());
            if (i == len - 1) {
                System.out.print("\n");
            } else {
                System.out.print(" ");
            }
            i++;
        }
    }

    public static void getBinaryString2(String str) {
        int i = 0;
        int len = str.length();
        if (len == 7) i++;

        while (i < len) {
            Integer num = 0;
            if (str.charAt(i) == 'a' || str.charAt(i) == 'A') {
                num = 10;
            } else if (str.charAt(i) == 'b' || str.charAt(i) == 'B') {
                num = 11;
            } else if (str.charAt(i) == 'c' || str.charAt(i) == 'C') {
                num = 12;
            } else if (str.charAt(i) == 'd' || str.charAt(i) == 'D') {
                num = 13;
            } else if (str.charAt(i) == 'e' || str.charAt(i) == 'E') {
                num = 14;
            } else if (str.charAt(i) == 'f' || str.charAt(i) == 'F') {
                num = 15;
            } else {
                num = str.charAt(i) - '0';
            }
            int a[], cnt = 0;
            a = new int[10];

            while (num > 0) {
                a[++cnt] = num & 1;
                num >>= 1;
            }

            while (cnt < 4) {
                a[++cnt] = 0;
            }

            for (int j = cnt; j >= 1; j--) {
                System.out.print(a[j]);
            }

            if (i == len - 1) {
                System.out.print("\n");
            } else {
                System.out.print(" ");
            }
            i++;
        }
    }

    //逐个数字通过除法计算二进制数
    public static void getBinaryString3(String str) {

    }

    //自定义各数字对应的二进制数组合输出
    public static void getBinaryString4(String str) {

    }
}

