package com.goinhn.algorithm.datastructure.linertable;

/**
 * <p>
 * 二分扩展
 * </p>
 *
 * @author goinhn
 * @date 2020-08-28T14:29:00
 */
public class FindOneLessValueIndex {

    public static int getLessIndex(int[] arr) {
        if (arr == null || arr.length == 0) {
            // no exist
            return -1;
        }
        if (arr.length == 1) {
            return 0;
        }

        int left = 1;
        int right = arr.length - 2;
        int mid = 0;
        while (left < right) {
            mid = (left + right) / 2;
            if (arr[mid] > arr[mid - 1]) {
                right = mid - 1;
            } else if (arr[mid] > arr[mid + 1]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return left;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i != arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {6, 5, 3, 4, 6, 8, 7};
        printArray(arr);
        int index = getLessIndex(arr);
        System.out.println("index: " + index + ", value: " + arr[index]);
    }

}
