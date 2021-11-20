package com.goinhn.interview._2020._20200426_tencent;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main_1 {

    private final List<Integer> list = new LinkedList<>();

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (scanner.hasNext()) {
            int lineNumber = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < lineNumber; i++) {
                int number = Integer.parseInt(scanner.nextLine());
                Main_1 now = new Main_1();
                for (int j = 0; j < number; j++) {
                    String[] caos = scanner.nextLine().split(" ");
                    now.every(caos);
                }
            }
        }


        scanner.close();
    }

    private void every(String[] caos) {
        String cao = caos[0];
        switch (cao) {
            case "PUSH":
                int x = Integer.parseInt(caos[1]);
                push(x);
                break;
            case "TOP":
                top();
                break;
            case "POP":
                pop();
                break;
            case "SIZE":
                size();
                break;
            case "CLEAR":
                clear();
                break;
            default:
                return;
        }
    }

    private void push(int x) {
        list.add(x);
    }

    private void top() {
        if (list.size() == 0) {
            System.out.println(-1);
        } else {
            System.out.println(list.get(0));
        }
    }

    private void pop() {
        if (list.size() == 0) {
            System.out.println(-1);
        } else {
//            System.out.println(list.get(0));
            list.remove(0);
        }
    }

    private void size() {
        System.out.println(list.size());
    }

    private void clear() {
        list.clear();
    }
}
