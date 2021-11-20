package com.goinhn.interview._2020._20200926_pinduoduo;

import java.util.*;

public class Main_1 {

    private static final Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        int count = scanner.nextInt();
        for (int i = 0; i < count; i++) {
            int n = scanner.nextInt();
            int[][] arr = new int[n][n];
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < n; y++) {
                    arr[x][y] = scanner.nextInt();
                }
            }
            System.out.println(getNum(arr, n));
        }
        scanner.close();
    }

    public static int getNum(int[][] arr, int n) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        map.put(0, Arrays.asList(0, 4, 4, 4, 4, 4, 4, 4, 0, 0));
        map.put(1, Arrays.asList(0, 2, 3, 2, 2, 2, 2, 4, 0, 0));
        map.put(2, Arrays.asList(0, 4, 6, 2, 2, 2, 2, 6, 0, 0));
        map.put(3, Arrays.asList(0, 4, 4, 2, 4, 2, 4, 4, 0, 0));
        map.put(4, Arrays.asList(0, 2, 3, 4, 4, 7, 2, 2, 0, 0));
        map.put(5, Arrays.asList(0, 2, 6, 2, 5, 2, 4, 4, 0, 0));
        map.put(6, Arrays.asList(0, 4, 2, 2, 5, 4, 4, 4, 0, 0));
        map.put(7, Arrays.asList(0, 6, 6, 2, 2, 2, 2, 2, 0, 0));
        map.put(8, Arrays.asList(0, 4, 4, 4, 4, 4, 4, 4, 0, 0));
        map.put(9, Arrays.asList(0, 4, 4, 4, 5, 2, 2, 4, 0, 0));

        Set<Integer> set = map.keySet();
        int tap = n / 10;
        for (Integer num : set) {
            for (int i = 0; i < 10; i++) {
                int temp = getOne(arr[i * tap]) / tap;
                if (temp != map.get(num).get(i)) {
                    break;
                } else if (temp == map.get(num).get(i) && i == 9) {
                    int middle = 10 * tap / 2 - 1;
                    if (num == 0 && arr[middle][middle] != 1) {
                        return 0;
                    } else if (num == 0 && arr[middle][middle] == 1) {
                        return 8;
                    } else {
                        return num;
                    }
                }
            }
        }

        return -1;
    }

    public static int getOne(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                count++;
            }
        }
        return count;
    }


}