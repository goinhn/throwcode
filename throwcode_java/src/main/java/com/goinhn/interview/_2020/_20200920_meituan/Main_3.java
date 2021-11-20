package com.goinhn.interview._2020._20200920_meituan;

import java.util.Scanner;
import java.util.Stack;

public class Main_3 {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] num = scanner.nextLine().split(" ");
        int sLength = Integer.parseInt(num[0]);
        int tLength = Integer.parseInt(num[1]);

        String s = scanner.nextLine();
        String t = scanner.nextLine();

        int count = location(s, t);
        if (count < 0) {
            System.out.println("No");
        } else {
            System.out.println("Yes");
            System.out.println(count);
        }
        scanner.close();
    }

//    public static int location(String s, String t) {
//        char[] sChar = s.toCharArray();
//        char[] tChar = t.toCharArray();
//
//        int index = -1;
//        int count = 0;
//        for (int i = 0; i < tChar.length; i++) {
//            int temp = -1;
//            for (int j = index + 1; j < sChar.length; j++) {
//                if (sChar[j] == tChar[i]) {
//                    index = j;
//                    temp = j + 1;
//                    break;
//                }
//            }
//            if (temp == -1) {
//                return -1;
//            } else {
//                count += temp;
//            }
//        }
//
//        return count;
//    }

    public static int location(String s, String t) {
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();

        Stack<Character> sStack = new Stack<>();
        Stack<Character> tStack = new Stack<>();

        for (int i = sChar.length - 1; i > -1; i--) {
            sStack.add(sChar[i]);
        }

        for (int i = tChar.length - 1; i > -1; i--) {
            tStack.add(tChar[i]);
        }

        int count = 0;
        int index = 1;
        while (!sStack.isEmpty() && !tStack.isEmpty()) {
            char sTop = sStack.peek();
            char tTop = tStack.peek();
            if (sTop == tTop) {
                count += index;
                tStack.pop();
            }
            sStack.pop();
            index++;
        }

        if (tStack.isEmpty()) {
            return count;
        } else {
            return -1;
        }
    }


}