package com.goinhn.throwcode.algorithm.sort;

/**
 * 冒泡排序
 * 稳定排序
 * time:O(n^2)
 * space:O(1)
 *
 * @author goinhn
 * @date 2020-08-23T0:09:00
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 4, 1, 3, 5};
        new BubbleSort().bubbleSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    private void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    /**
     * x = a ^ b;
     * y = (a ^ b) ^ b;
     * x = (a ^ b ^ (a ^ b ^ b)
     */
    private void swapBit(int[] arr, int x, int y) {
        arr[x] = arr[x] ^ arr[y];
        arr[y] = arr[x] ^ arr[y];
        arr[x] = arr[x] ^ arr[y];
    }

}
