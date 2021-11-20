package com.goinhn.algorithm;

/**
 * <p>
 * 小和问题
 * </p>
 * <p>
 * 在一个数组中，每一个数左边比当前数小的数累加起来，叫做这个数组的小和。求一个数组的小和。
 * </p>
 * <p>
 * 例子：
 * [1,3,4,2,5]
 * 1左边比1小的数，没有；
 * 3左边比3小的数，1；
 * 4左边比4小的数，1、3；
 * 2左边比2小的数，1；
 * 5左边比5小的数，1、3、4、2；
 * 所以小和为1+1+3+1+1+3+4+2=16
 * </p>
 * <p>
 * 使用归并的思想，在数组排序的过程中分成几个组，进行统计，防止重复的统计
 * </P>
 *
 * @author goinhn
 * @date 2020-08-23T11:59:22
 */
public class SmallSum {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 4, 5};
        System.out.println(smallSum(arr));
    }

    /**
     * 判断初始化方法
     *
     * @param arr
     * @return
     */
    public static int smallSum(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }

        return mergeSort(arr, 0, arr.length - 1);
    }

    /**
     * 归并排序
     *
     * @param arr
     * @param l
     * @param r
     * @return
     */
    public static int mergeSort(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }

        int m = l + ((r - l) >> 1);

        return mergeSort(arr, l, m) + mergeSort(arr, m + 1, r) + findSmall(arr, l, m, r);
    }

    /**
     * 在归并排序的数组合并中寻找小的值
     *
     * @param arr
     * @param l
     * @param m
     * @param r
     * @return
     */
    public static int findSmall(int[] arr, int l, int m, int r) {
        int[] arrTemp = new int[r - l + 1];
        int index = 0;
        int pl = l;
        int pr = m + 1;
        int sum = 0;

        while (pl <= m && pr <= r) {
            if (arr[pl] < arr[pr]) {
                // 将小于右边的数的个数和该数作乘积获得最后的值，注意因为是排好序的所有直接统计个数即可
                sum += (r - pr + 1) * arr[pl];
                arrTemp[index++] = arr[pl++];
            } else {
                arrTemp[index++] = arr[pr++];
            }
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

        return sum;
    }

}
