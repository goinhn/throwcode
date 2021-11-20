package com.goinhn.algorithm.sort;


/**
 * <p>
 * 插入排序
 * 非稳定排序
 * </p>
 * <p>
 * 时间复杂度 O(N^2)
 * 空间复杂度 O(1)
 * </p>
 *
 * @author goinhn
 * @date 2020-08-23T0:33:00
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 1, 5};
        insertionSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    /**
     * 插入排序
     *
     * @param arr
     */
    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
                swap(arr, j - 1, j);
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
