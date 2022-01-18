package com.goinhn.throwcode.algorithm.sort;

/**
 * 希尔排序
 * time:O(nlogn)
 * space:O(1)
 *
 * @author goinhn
 * @date 2020-11-22T20:27:02
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 4, 1, 3, 5};
        new ShellSort().shellSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    private void shellSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
//       确定划分的gap大小
        int gap = arr.length / 2;
        while (gap > 0) {
//            分成gap个数量的组，每组进行插入排序
            for (int i = 0; i < gap; i++) {
                for (int j = gap; j < arr.length; j++) {
                    for (int m = j; m > 0 && arr[m] < arr[m - gap]; m -= gap) {
                        swap(arr, m, m - gap);
                    }
                }
            }
//            减小gap间隙进行重复分组插入排序
            gap /= 2;
        }
    }

    private void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

}
