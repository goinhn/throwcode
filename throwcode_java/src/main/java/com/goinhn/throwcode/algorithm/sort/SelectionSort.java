package com.goinhn.throwcode.algorithm.sort;

/**
 * 选择排序
 * 稳定排序
 * time:O(n^2)
 * space:O(1)
 *
 * @author goinhn
 * @date 2020-08-23T0:25:00
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 4, 1, 3, 5};
        new SelectionSort().selectionSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public void selectionSort(int[] arr) {
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

    private void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

}
