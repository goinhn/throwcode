package com.goinhn.throwcode.algorithm.sort;


/**
 * 插入排序
 * 非稳定排序
 * time:O(n^2)
 * space:O(1)
 *
 * @author goinhn
 * @date 2020-08-23T0:33:00
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 1, 5};
        new InsertionSort().insertionSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
                swap(arr, j - 1, j);
            }
        }
    }

    private void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

}
