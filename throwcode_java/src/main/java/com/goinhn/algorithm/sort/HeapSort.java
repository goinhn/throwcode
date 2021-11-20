package com.goinhn.algorithm.sort;

/**
 * <p>
 * 堆排序
 * </p>
 * <p>
 * 时间复杂度：O(N*logN)
 * 空间复杂度：O(1)
 * </p>
 * <p>
 * 完全二叉树
 * 数组表示完全二叉树
 * 父节点：i，
 * 左子树：2*i+1，
 * 右子树：2*i+2，
 * </p>
 * <p>
 * 子树：i，
 * 父节点：(i-1)/2
 * </p>
 * <p>
 * 小根堆：任何一个子树的最小值都在头部，
 * 大根堆，任何一个子树的最大值都在头部
 * </p>
 * <p>
 * 堆操作
 * 将一个数组转换为大根堆或者小根堆的结构
 * heapInsert
 * 改变堆的头结点，继续转换为大根堆和小根堆的结构
 * heapify
 * </p>
 *
 * @author goinhn
 * @date 2020-08-25T12:25:18
 */
public class HeapSort {

    /**
     * 堆排序检查
     *
     * @param arr
     */
    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }

        int end = arr.length;
        swap(arr, 0, --end);
        while (end > 0) {
            heapify(arr, 0, end);
            swap(arr, 0, --end);
        }
    }

    /**
     * 构建大根堆过程
     *
     * @param arr
     * @param index
     */
    public static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    /**
     * 堆化的过程
     *
     * @param arr
     * @param index 进行堆化的数组的左边界，也即堆的头结点
     * @param end   进行堆化的数组的右边界，也即堆的尾部
     */
    public static void heapify(int[] arr, int index, int end) {
        int left = index * 2 + 1;
        while (left < end) {
            int largest = left + 1 < end && arr[left] < arr[left + 1] ? left + 1 : left;
            largest = arr[index] > arr[largest] ? index : largest;

            // 最大值已经是为头结点则已经堆化完成
            if (largest == index) {
                break;
            }

            swap(arr, largest, index);
            index = largest;
            left = index * 2 + 1;
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

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 7, 1, 2, 0, 5, 10};
        heapSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

}