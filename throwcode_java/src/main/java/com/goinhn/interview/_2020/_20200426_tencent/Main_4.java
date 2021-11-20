package com.goinhn.interview._2020._20200426_tencent;

import java.util.Scanner;
import java.util.Stack;

public class Main_4 {

    private static final Scanner scanner = new Scanner(System.in);

    private final Stack<Integer> stackBefore = new Stack<>();

    private final Stack<Integer> stackAfter = new Stack<>();

    public static void main(String[] args) {
        while (scanner.hasNext()) {
            int lineNumber = Integer.parseInt(scanner.nextLine());
            Main_4 now = new Main_4();
            for (int i = 0; i < lineNumber; i++) {
                String[] caos = scanner.nextLine().split(" ");
                now.every(caos);
            }
        }
    }

    private void every(String[] caos) {
        String cao = caos[0];
        switch (cao) {
            case "add":
                int x = Integer.parseInt(caos[1]);
                add(x);
                break;
            case "poll":
                poll();
                break;
            case "peek":
                peek();
                break;
            default:
                return;
        }
    }

    private void add(int x) {
        stackAfter.add(x);
    }

    private void poll() {
        if (stackBefore.size() != 0) {
            stackBefore.pop();
        } else {
            if (stackAfter.size() != 0) {
                stackAfter.remove(0);
            }
        }
    }

    private void peek() {
        if (stackBefore.size() != 0) {
            System.out.println(stackBefore.peek());
        } else {
            if (stackAfter.size() != 0) {
                System.out.println(stackAfter.get(0));
            }
        }
    }

}
