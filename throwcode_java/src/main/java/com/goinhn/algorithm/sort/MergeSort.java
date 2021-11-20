package com.goinhn.algorithm.sort;

/**
 * <p>
 * 归并排序
 * 递归思想
 * </p>
 * <p>
 * 时间复杂度 O(N*logN)
 * 空间复杂度 O(N)
 * </p>
 * <p>
 * 注意数组转换的时候下标的位置
 * </p>
 *
 * @author goinhn
 * @date 2020-08-23T10:53:57
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 1, 6, 3};
        mergeSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    /**
     * 合并排序
     *
     * @param arr
     */
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        mergeSort(arr, 0, arr.length - 1);
    }

    /**
     * 递归方法
     *
     * @param arr
     * @param l
     * @param r
     */
    public static void mergeSort(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }

        // 求平均，移位符号操作要加上括号()
        int m = l + ((r - l) >> 1);
        mergeSort(arr, l, m);
        mergeSort(arr, m + 1, r);
        merge(arr, l, m, r);
    }

    /**
     * 合并数组方法
     *
     * @param l
     * @param r
     * @return
     */
    public static void merge(int[] arr, int l, int m, int r) {
        int[] arrTemp = new int[r - l + 1];
        // 临时存储数组指针
        int index = 0;
        // 左数组的指针
        int pl = l;
        // 右数组的指针
        int pr = m + 1;

        while (pl <= m && pr <= r) {
            arrTemp[index++] = arr[pl] < arr[pr] ? arr[pl++] : arr[pr++];
        }

        while (pl <= m) {
            arrTemp[index++] = arr[pl++];
        }

        while (pr <= r) {
            arrTemp[index++] = arr[pr++];
        }

        for (int i = 0; i < arrTemp.length; i++) {
            arr[l + i] = arrTemp[i];
        }
    }

}
