package com.goinhn.interview._2020._20200503_bytedance;

import java.util.*;

public class Main_2 {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (scanner.hasNextLine()) {
            String[] line = scanner.nextLine().split(" ");
            int n = Integer.parseInt(line[0]);
            int R = Integer.parseInt(line[1]);
            int r = Integer.parseInt(line[2]);

            Map<Integer, String> map = new LinkedHashMap<>(n);
            for (int i = 1; i <= n; i++) {
                String[] lineNow = scanner.nextLine().split(" ");
                map.put(i, lineNow[0] + " " + lineNow[1]);
            }

            sort(R, r, map);
        }
        scanner.close();
    }

    private static void sort(int R, int r, Map<Integer, String> map) {
        Set<Integer> set = map.keySet();
        if (2 * r < R) {
            for (Integer integer : set) {
                System.out.print(integer + " ");
            }
            return;
        }

        Set<Integer> setBefore = new HashSet<>();
        Set<Integer> setMiddle = new HashSet<>();
        Set<Integer> setAfter = new HashSet<>();
        for (Integer integer : set) {
            String str = map.get(integer);
            String[] strs = str.split(" ");
            double location = location(Integer.parseInt(strs[0]), Integer.parseInt(strs[1]));
            if (location <= (2 * r - R) * (2 * r - R)) {
                setBefore.add(integer);
            } else if (location > (2 * r - R) * (2 * r - R) && location < R * R) {
                setMiddle.add(integer);
            } else {
                setAfter.add(integer);
            }
        }

        for (Integer integer : setBefore) {
            System.out.print(integer + " ");
        }
        for (Integer integer : setMiddle) {
            System.out.print(integer + " ");
        }

        for (Integer integer : setAfter) {
            System.out.println(integer + " ");
        }
    }

    private static double location(double x, double y) {
        return x * x + y * y;
    }

}
