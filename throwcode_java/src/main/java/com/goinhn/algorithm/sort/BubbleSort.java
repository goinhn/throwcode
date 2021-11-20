package com.goinhn.algorithm.sort;

/**
 * <p>
 * 冒泡排序
 * 稳定排序
 * </p>
 * <p>
 * 时间复杂度 O(N^2)
 * 空间复杂度 O(1)
 * </p>
 *
 * @author goinhn
 * @date 2020-08-23T0:09:00
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 4, 1, 3, 5};
        bubbleSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    /**
     * 冒泡排序
     *
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
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

    /**
     * 交换方法
     *
     * @param arr
     * @param x
     * @param y
     */
    public static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

}
