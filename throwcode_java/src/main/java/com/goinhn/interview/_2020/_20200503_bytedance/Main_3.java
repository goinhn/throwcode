package com.goinhn.interview._2020._20200503_bytedance;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main_3 {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (scanner.hasNextLine()) {
            Integer n = Integer.parseInt(scanner.nextLine());

            List<Integer> listMan = new LinkedList<>();
            List<Integer> listLocation = new LinkedList<>();

            String[] strMan = scanner.nextLine().split(" ");
            String[] strLocation = scanner.nextLine().split(" ");
            for (int i = 0; i < n; i++) {
                listMan.add(Integer.parseInt(strMan[i]));
                listLocation.add(Integer.parseInt(strLocation[i]));
            }

            time(listMan, listLocation);
        }
        scanner.close();
    }

    private static void time(List<Integer> listMan, List<Integer> listLocation) {
        int sum = sum(listMan);
        int min = min(listLocation);
        int max = max(listLocation);

        int another = sum - max - min - 1;

        if (another % 2 == 0) {
            System.out.println(another / 2);
        } else {
            System.out.println(another / 2 - 1);
        }
    }

    private static int sum(List<Integer> list) {
        int sum = 0;
        for (Integer integer : list) {
            sum += integer;
        }

        return sum;
    }

    private static int min(List<Integer> list) {
        int min = Integer.MAX_VALUE;
        for (Integer integer : list) {
            min = min < integer ? min : integer;
        }

        return min;
    }

    private static int max(List<Integer> list) {
        int max = Integer.MIN_VALUE;
        for (Integer integer : list) {
            max = max > integer ? max : integer;
        }

        return max;
    }
}
