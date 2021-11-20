package com.goinhn.interview._2020._20200416_meituan;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main_2 {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (scanner.hasNext()) {
            String[] line = scanner.nextLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            int m = Integer.parseInt(line[2]);
            int x = Integer.parseInt(line[3]);

            System.out.println(new Main_2().loop(a, b, m, x));
        }

        scanner.close();
    }

    private int loop(int a, int b, int m, int x) {
        List<Integer> list = new LinkedList<>();
        int result = 0;
        while (true) {
            x = (a * x + b) % m;
            list.add(x);
            if(isNow(list) != 0){
                result = isNow(list);
                break;
            }
        }

        return result;
    }

    private int isNow(List<Integer> list) {
        int value = list.get(0);
        int index = 0;
        for (int i = 1; i < list.size(); i++) {
            if (value == list.get(i)) {
                index = i;
            }
        }

        boolean flag = true;
        for (int i = 0; i < index; i++) {
            if (index + i >= list.size() || !list.get(i).equals(list.get(index + i))) {
                flag = false;
                break;
            }
        }
        if (flag) {
            return index;
        } else {
            return 0;
        }

    }


}
