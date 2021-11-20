package com.goinhn.interview._2020._20200927_weizhongyinhang;

import java.util.Scanner;

public class Main_3 {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int count = scanner.nextInt();
        int[] arr = new int[count];
        for (int i = 0; i < count; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println(getNum(arr));
        scanner.close();

    }

//    public static int getNum(int[] arr) {
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 1; i < arr.length - 1; i++) {
//            int count = 0;
//            for (int j = i + 1; j < arr.length; j++) {
//                if (arr[j] >= arr[i]) {
//                    count++;
//                }
//            }
//            map.put(i, count);
//        }
//
//        int count = 0;
//        for (int i = 0; i < arr.length - 2; i++) {
//            for (int j = i + 1; j < arr.length - 1; j++) {
//                if (arr[j] < arr[i]) {
//                    continue;
//                }
//                count += map.get(j);
//            }
//        }
//
//        return count;
//    }

    public static int getNum(int[] arr) {
        int count = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 2; i++) {
            int tempCount = 0;
            if(min <= arr[i]) {
                continue;
            }
            min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] >= arr[j - 1]) {
                    tempCount++;
                }
            }

            if (tempCount < 2) {
                continue;
            }

            System.out.println(tempCount);
            count += loopAdd(tempCount);
        }

        return count;
    }

    public static int loopAdd(int num) {
        return num * (num - 1) / 2;
    }

}