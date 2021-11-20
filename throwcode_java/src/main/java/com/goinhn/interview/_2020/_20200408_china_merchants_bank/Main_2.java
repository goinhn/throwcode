package com.goinhn.interview._2020._20200408_china_merchants_bank;//package com.goinhn.interview.zhaoshangyinghang20200408;
//
//import java.util.*;
//
//public class Main_2 {
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int lineNumber = Integer.parseInt(scanner.nextLine());
//        String[] str = new String[lineNumber];
//        int[] number = new int[lineNumber];
//        for (int i = 0; i < lineNumber; i++) {
//            String[] temp = scanner.nextLine().split(" ");
//            str[i] = temp[0];
//            number[i] = Integer.parseInt(temp[1]);
//        }
//
//        int[] result = new Main().isK(str, number);
//        for (int i : result) {
//            System.out.println(i);
//        }
//    }
//
//    private int[] isK(String[] str, int[] number) {
//        int length = str.length;
//        int[] result = new int[length];
//
//        for (int i = 0; i < length; i++) {
//            int strLength = str[i].length();
//            int local = 1;
//            while (number[i] / 10 > 0) {
//                number[i] /= 10;
//                local++;
//            }
//
//            if (local > strLength) {
//                result[i] = 0;
//                break;
//            }
//
//            if (local == strLength && number[i] == Integer.parseInt(str[i])) {
//                result[i] = 0;
//                break;
//            }
//
//            Map<Integer, Character> map = new HashMap<>();
//            for (int j = 0; j < strLength - 1; j++) {
//                for (int x = 0; x < strLength - 1; x++) {
//                    for (int y = 0; y < strLength; y++) {
//                        map.put(j, '+');
//                    }
//                }
//            }
//
//
//        }
//
//        return result;
//    }
//
//    private List<Integer> fen(String str) {
//        List<Integer> list = new ArrayList<>();
//
//        String[] temp = str.split("");
//
//        for (String s : temp) {
//            list.add(Integer.parseInt(s));
//        }
//
//        return list;
//    }
//
//
//}