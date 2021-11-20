package com.goinhn.niuke.huawei.test710802;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * https://www.nowcoder.com/test/question/analytic?tid=32588204
 * 华为2016研发工程师编程题
 */
public class Main_1 {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = i;
            }
            System.out.println(new Main_1().delete(arr));
        }
        scanner.close();
    }

    private int delete (int[] arr) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            queue.add(arr[i]);
        }
        while (queue.size() != 1) {
            int count = 0;
            while (count != 2) {
                queue.add(queue.peek());
                queue.poll();
                count++;
            }
            queue.poll();
        }
        return queue.element();
    }
}



