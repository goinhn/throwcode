package com.goinhn.interview._2020._20200408_china_merchants_bank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 招商银行
 */
public class Main_1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lineNumber = Integer.parseInt(scanner.nextLine());
        String[] str = new String[lineNumber];

        for (int i = 0; i < lineNumber; i++) {
            str[i] = scanner.nextLine();
        }

        new Main_1().isStr(str);
    }

    private void isStr(String[] str) {
        for (int j = 0; j < str.length; j++) {
            Map<Character, Character> map = new HashMap<>(9);
            map.put('1', '1');
            map.put('2', '5');
            map.put('5', '2');
            map.put('3', '8');
            map.put('8', '3');
            map.put('4', '7');
            map.put('7', '4');
            map.put('6', '9');
            map.put('9', '6');

            String strRev = new StringBuilder(str[j]).reverse().toString();

            boolean flag = true;
            for (int i = 0; i < strRev.length(); i++) {
                Character a = str[j].charAt(i);
                Character b = strRev.charAt(i);

                if (!map.get(a).equals(b)) {
                    flag = false;
                    System.out.println("NO");
                    break;
                }
            }
            if (flag) {
                System.out.println("YES");
            }
        }
    }


}