package com.goinhn.throwcode.algorithm.sort;

/**
 * 桶排序
 * time:O(N)
 * space:O(N)
 *
 * @author goinhn
 * @date 2020-08-26T16:35:19
 */
public class BucketSort {

    public static void main(String[] args) {
        int[] arr = new int[]{-1, -2, 1, 2, 5};
        new BucketSort().bucketSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    /**
     * 桶排序，针对特定的数据，这里考虑整数
     */
    public void bucketSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int min = arr[0];
        int max = arr[0];
        for (int i : arr) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }

        // 移动到和原点平行
        int distance = -min;

        // 创建桶并将数组中的数据塞入桶中
        int[] bucket = new int[max - min + 1];
        for (int i : arr) {
            bucket[i + distance]++;
        }

        // 将数据还原数组中
        int index = 0;
        for (int i = 0; i < bucket.length; i++) {
            while (bucket[i]-- > 0) {
                arr[index++] = i - distance;
            }
        }
    }

}
