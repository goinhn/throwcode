package com.goinhn.algorithm.sort;

/**
 * <p>
 * 选择排序
 * 稳定排序
 * </p>
 * <p>
 * 时间复杂度 O(N^2)
 * 空间复杂度 O(1)
 * </p>
 *
 * @author goinhn
 * @date 2020-08-23T0:25:00
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 4, 1, 3, 5};
        selectionSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    /**
     * 选择算法
     *
     * @param arr
     */
    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
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
