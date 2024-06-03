package com.goinhn.thorwcode.leetcode.test;

<<<<<<< Updated upstream
/**
 * @author goinhn
 * @date 2024/4/8
 */
public class Main {
    public static void main(String[] args) {

=======
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String op = scanner.nextLine();
        String item = scanner.nextLine();
        String[] opArr = op.split(",");
        String[] itemArr = op.split(",", -1);
        if (opArr.length == 0 || itemArr.length == 0) {
            return;
        }
        MyQueue myQueue = new MyQueue();
        List<String> result = new ArrayList<>();
        for (int i = 0; i < opArr.length; i++) {
            switch (opArr[i]) {
                case "push":
                    Integer x = Integer.parseInt(itemArr[i]);
                    myQueue.push(x);
                    result.add("null");
                    break;
                case "pop":
                    result.add(String.valueOf(myQueue.pop()));
                    break;
                case "peek":
                    result.add(String.valueOf(myQueue.peek()));
                    break;
                case "empty":
                    result.add(String.valueOf(myQueue.empty()));
                    break;
            }
        }
        String res = String.join(",", result);
        System.out.println(res);
    }

    public static class MyQueue {
        private Stack<Integer> pushStack = new Stack<>();
        private Stack<Integer> popStack = new Stack<>();

        public void push(int x) {
            pushStack.push(x);
        }

        public int pop() {
            if (popStack.empty()) {
                trans();
            }
            return popStack.pop();
        }

        public int peek() {
            if (popStack.empty()) {
                trans();
            }
            return popStack.peek();
        }

        public boolean empty() {
            return popStack.empty() && pushStack.empty();
        }

        private void trans() {
            while(!pushStack.empty()) {
                popStack.push(pushStack.pop());
            }
        }
>>>>>>> Stashed changes
    }
}
