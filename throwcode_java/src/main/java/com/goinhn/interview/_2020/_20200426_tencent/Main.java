package com.goinhn.interview._2020._20200426_tencent;//import org.omg.CORBA.INTERNAL;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class Main {
//
//    private static final Scanner scanner = new Scanner(System.in);
//
//    public static void main(String[] args) {
//        while (scanner.hasNext()) {
//            int n = Integer.parseInt(scanner.nextLine());
//            List<Integer> listA = make(n);
//            List<Integer> listB = make(n);
//            System.out.println(ci(listA, listB));
//        }
//    }
//
//    private static List<Integer> make(int size) {
//        List<Integer> list = new ArrayList<>(size);
//        String[] numbers = scanner.nextLine().split(" ");
//        for (int i = 0; i < size; i++) {
//            list.add(Integer.parseInt(numbers[i]));
//        }
//
//        return list;
//    }
//
//    private static int ci(List<Integer> listA, List<Integer> listB) {
//        int time = 0;
//        for (int i = 0; i < listA.size() - 1; i++) {
//            if (listA.get(i) > listA.get(i + 1)) {
//                time++;
//                listA.set(i, listB.get)
//            }
//        }
//
//        return time;
//    }
//}
