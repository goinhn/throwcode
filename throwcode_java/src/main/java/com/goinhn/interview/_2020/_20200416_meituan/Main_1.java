package com.goinhn.interview._2020._20200416_meituan;

import java.util.*;

/**
 * 网易互娱
 */
public class Main_1 {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (scanner.hasNext()) {
            String lineNumber = scanner.nextLine();
            int n = Integer.parseInt(lineNumber.split(" ")[0]);
            int m = Integer.parseInt(lineNumber.split(" ")[1]);

            Map<Integer, Map<Integer, Integer>> map = new HashMap<>(n);
            for (int i = 0; i < n; i++) {
                String N = scanner.nextLine();
                String[] nArray = N.split(" ");
                Map<Integer, Integer> mapN = new HashMap<>(m);
                for (int j = 0; j < m; j++) {
                    mapN.put(j, Integer.parseInt(nArray[j]));
                }
                map.put(i, mapN);
            }

            System.out.println(new Main_1().getHow(map, m));
        }
    }


    private int getHow(Map<Integer, Map<Integer, Integer>> map, int m) {
        if (map.size() == 0) {
            return 0;
        }

        Set<Integer> set = map.keySet();

        int max = -1;
        int lo = -1;
        Set<Integer> setResult = new HashSet<>();
        for (int i = 0; i < m; i++) {
            lo = -1;
            max = -1;
            for (Integer integer : set) {
                if (max < map.get(integer).get(i)) {
                    max = map.get(integer).get(i);
                    lo = integer;
                }
            }
            if (!setResult.contains(lo)) {
                setResult.add(lo);
            }
            for (Integer integer : set) {
                if (max == map.get(integer).get(i)) {
                    if (!setResult.contains(integer)) {
                        setResult.add(integer);
                    }
                }
            }
        }

        return setResult.size();
    }


}
