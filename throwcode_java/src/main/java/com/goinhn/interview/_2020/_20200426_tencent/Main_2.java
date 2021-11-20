package com.goinhn.interview._2020._20200426_tencent;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_2 {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (scanner.hasNext()) {
            int T = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < T; i++) {
                int n = Integer.parseInt(scanner.nextLine());
                List<List<Integer>> listA = sheng(n);
                List<List<Integer>> listB = sheng(n);

                double min = minLength(listA, listB);
                String result = String.format("%.4f", min);

                System.out.println(result);
            }
        }

        scanner.close();
    }

    private static List<List<Integer>> sheng(int size) {
        List<List<Integer>> list = new ArrayList<>(size);
        for (int j = 0; j < size; j++) {
            String[] line = scanner.nextLine().split(" ");
            int one = Integer.parseInt(line[0]);
            int two = Integer.parseInt(line[1]);
            List<Integer> middle = new ArrayList<>(2);
            middle.add(one);
            middle.add(two);
            list.add(middle);
        }
        return list;
    }

    private static double minLength(List<List<Integer>> listA, List<List<Integer>> listB) {
        double min = Double.MAX_VALUE;
        int minNumber = Integer.MAX_VALUE;

        for (int i = 0; i < listA.size(); i++) {
            int x1 = listA.get(i).get(0);
            int y1 = listA.get(i).get(1);
            for (int j = 0; j < listB.size(); j++) {
                int x2 = listB.get(j).get(0);
                int y2 = listB.get(j).get(1);

                if (Math.abs(x1 - x2) + Math.abs(y1 - y2) <= minNumber) {
                    double minTemp = Math.sqrt(Math.abs(x1 - x2) * Math.abs(x1 - x2) + Math.abs(y1 - y2) * Math.abs(y1 - y2));
                    if (min > minTemp) {
                        min = minTemp;
                        minNumber = Math.abs(x1 - x2) + Math.abs(y1 - y2);
                    }
                }
            }
        }

        return min;
    }


}

