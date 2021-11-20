package com.goinhn.algorithm;

/**
 * <p>
 * 荷兰国旗问题
 * </p>
 * <p>
 * 给定一个数组arr，和一个数num，请把小于num的数字放在数组的左边，等于num的数字放在数组的中间，大于num的数字放在数组的右边
 * </p>
 *
 * @author goinhn
 * @date 2020-08-25T10:27:39
 */
public class NetherlandsFlag {

    /**
     * less指针停靠在数组的最左侧，more指针停靠在数组的最右侧，current指针从左开始遍历直到遇见more指针
     *
     * @param arr
     * @param num
     */
//    public static int[] netherlandsFlag(int[] arr, int l, int r, int num) {
//        int less = l - 1;
//        int more = r + 1;
//        int current = l;
//        while (current < more) {
//            if (arr[current] < num) {
//                swap(arr, current++, ++less);
//            } else if (arr[current] > num) {
//                swap(arr, current, --more);
//            } else {
//                current++;
//            }
//        }
//
//        return new int[]{less + 1, more - 1};
//    }

    /**
     * 节省一个current的指针的变量
     *
     * @param arr
     * @param l
     * @param r
     * @param num
     * @return
     */
    public static int[] netherlandsFlag(int[] arr, int l, int r, int num) {
        int less = l - 1;
        int more = r + 1;
        while (l < more) {
            if (arr[l] < num) {
                swap(arr, l++, ++less);
            } else if (arr[l] > num) {
                swap(arr, l, --more);
            } else {
                l++;
            }
        }

        return new int[]{less + 1, more - 1};
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

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 1, 2, 3, 4, 5};
        int num = 3;
        int[] result = netherlandsFlag(arr, 0, arr.length - 1, num);
        System.out.println(result[0] + "," + result[1]);
        for (int i : arr) {
            System.out.println(i);
        }
    }

}
