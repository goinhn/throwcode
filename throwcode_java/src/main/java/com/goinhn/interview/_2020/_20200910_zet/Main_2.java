package com.goinhn.interview._2020._20200910_zet;

import java.util.*;


/**
 * <p>
 *
 * </p>
 *
 * @author goinhn
 * @date 2020-09-10T23:09:39
 */
public class Main_2 {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int length = scanner.nextInt();
        int count = scanner.nextInt();
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = scanner.nextInt();
        }

        for (int i = 0; i < count; i++) {
            int command = scanner.nextInt();
            int num = scanner.nextInt();

            if (command == 1) {
                change(arr, num);
            }

            if (command == 2) {
                print(arr, num);
            }
        }

        scanner.close();
    }


    public static void change(int[] arr, int node) {
        node--;
        int left = node * 2 + 1;
        int right = node * 2 + 2;
        if (left < arr.length && right >= arr.length) {
            int max = arr[node] > arr[left] ? node : left;
            if (max == left) {
                swap(arr, node, left);
            }
        }

        if (right < arr.length) {
            int max = arr[node] > arr[left] ? node : left;
            if (max == left) {
                swap(arr, node, left);
            }

            max = arr[node] > arr[right] ? node : right;
            if (max == right) {
                swap(arr, node, right);
            }

            max = arr[left] > arr[right] ? left : right;
            if (max == right) {
                swap(arr, left, right);
            }
        }
    }

    public static void print(int[] arr, int depth) {
        int count = (int) Math.pow(2, depth - 1);
        int first = count - 1;

        for (int i = 0; i < count && first + i < arr.length; i++) {
            System.out.print(arr[first + i] + " ");
        }
        System.out.println();
    }

    public static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

}

