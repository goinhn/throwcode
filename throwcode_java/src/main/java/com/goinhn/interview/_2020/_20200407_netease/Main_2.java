package com.goinhn.interview._2020._20200407_netease;//package com.goinhn.interview.netease20200407;
//
//import java.util.*;
//
//public class Main_2 {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        int n = 0;
//        int defend = 0;
//
//
//        String line = scanner.nextLine();
//        String[] array = line.split(" ");
//        n = Integer.parseInt(array[0]);
//        defend = Integer.parseInt(array[1]);
//
//        int[] de = new int[n];
//        int[] ac = new int[n];
//
//        line = scanner.nextLine();
//        array = line.split(" ");
//        for (int j = 0; j < array.length; j++) {
//            de[j] = Integer.parseInt(array[j]);
//        }
//
//        line = scanner.nextLine();
//        array = line.split(" ");
//        for (int j = 0; j < array.length; j++) {
//            ac[j] = Integer.parseInt(array[j]);
//        }
//
//        System.out.println(new Main().less(defend, de, ac));
//
//    }
//
//    private int less(int defend, int[] de, int[] ac) {
//        int less = 0;
//
//        int index = 0;
//        int[] ex = new int[de.length];
//
//        for (int i = 0; i <= de.length; i++) {
//            if (de[i] >= defend) {
//                index += min(ac);
//                less += ac[index];
//                ex[]
//            }
//            defend++;
//        }
//
//        return less;
//    }
//
//    private int min(int[] a) {
//        int min = a[0];
//        int index = 0;
//        for (int i = 1; i < a.length; i++) {
//            if(min > a[i]) {
//                index = i;
//            }
//        }
//        return index;
//    }
//
//
//}
//
