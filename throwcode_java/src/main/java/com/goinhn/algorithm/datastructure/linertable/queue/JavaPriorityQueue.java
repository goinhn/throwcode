package com.goinhn.algorithm.datastructure.linertable.queue;

import java.util.Arrays;

/**
 * <p>
 * leetcode 703
 * <p>
 * 设计一个找到数据流中第K大元素的类（class）。注意是排序后的第K大元素，不是第K个不同的元素。
 * <p>
 * 你的KthLargest类需要一个同时接收整数k 和整数数组nums的构造器，它包含数据流中的初始元素。每次调用KthLargest.add，返回当前数据流中第K大的元素。
 * <p>
 * 示例:
 * <p>
 * int k = 3;
 * int[] arr = [4,5,8,2];
 * KthLargest kthLargest = new KthLargest(3, arr);
 * kthLargest.add(3); // returns 4
 * kthLargest.add(5); // returns 5
 * kthLargest.add(10); // returns 5
 * kthLargest.add(9); // returns 8
 * kthLargest.add(4); // returns 8
 * 说明:
 * 你可以假设nums的长度≥k-1且k ≥1。
 * <p>
 * 时间复杂度:O(n)
 * 空间复杂度:O(n)
 * </p>
 *
 * @author goinhn
 * @date 2020-09-14T17:38:17
 */
public class JavaPriorityQueue {

    /**
     * 通过排序数组只保存前面k个大的值
     */
    class KthLargest {

        public int[] kNums;
        int size;

        /**
         * 利用k大小的数组来进行保存前k个大的元素
         * <p>
         * 来一个元素先判断是否能加入数组，不能加入前k个大的受罪则直接返回原有的数组
         *
         * @param k
         * @param nums
         */
        public KthLargest(int k, int[] nums) {
            size = Math.min(nums.length, k);
            kNums = new int[k];
            Arrays.sort(nums);
            for (int i = 0; i < size; i++) {
                kNums[i] = nums[nums.length - i - 1];
            }
        }

        public int add(int val) {
            if (size < kNums.length) {
                kNums[size++] = val;
                changeLocation();
            } else if (kNums[kNums.length - 1] < val) {
                kNums[kNums.length - 1] = val;
                changeLocation();
            }


            return kNums[kNums.length - 1];
        }

        public void changeLocation() {
            for (int i = kNums.length - 1; i > 0; i--) {
                if (kNums[i] > kNums[i - 1]) {
                    swap(kNums, i, i - 1);
                } else {
                    break;
                }
            }
        }

        public void swap(int[] arr, int x, int y) {
            int temp = arr[x];
            arr[x] = arr[y];
            arr[y] = temp;
        }
    }


    /**
     * 利用小顶堆的结构
     * 来存储前k个大的数的值，
     */
    class KthLargestMiniHeap {

        public int[] kNums;
        int size;

        /**
         * 利用小跟堆的结构（优先级队列）
         *
         * @param k
         * @param nums
         */
        public KthLargestMiniHeap(int k, int[] nums) {
            Arrays.sort(nums);

            kNums = new int[k];
            size = Math.min(nums.length, k);
            System.arraycopy(nums, nums.length - size, kNums, 0, size);
            if (size == k) {
                for (int i = 0; i < kNums.length; i++) {
                    heapInsert(kNums, i);
                }
            }
        }

        public int add(int val) {
            if (size < kNums.length) {
                kNums[size++] = val;
                for (int i = 0; i < size; i++) {
                    heapInsert(kNums, i);
                }
            } else if (kNums[0] < val) {
                kNums[0] = val;
                heapify(kNums, 0, kNums.length);
            }

            return kNums[0];
        }

        public void heapInsert(int[] arr, int index) {
            while (arr[index] < arr[index / 2]) {
                swap(arr, index, index / 2);
                index = index / 2;
            }
        }

        public void heapify(int[] arr, int index, int end) {
            int left = index * 2 + 1;
            while (left < end) {
                int smallest = left + 1 < end && arr[left] > arr[left + 1] ? left + 1 : left;
                smallest = arr[index] < arr[smallest] ? index : smallest;

                if (smallest == index) {
                    break;
                }

                swap(arr, index, smallest);
                index = smallest;
                left = index * 2 + 1;
            }
        }

        public void swap(int[] arr, int x, int y) {
            int temp = arr[x];
            arr[x] = arr[y];
            arr[y] = temp;
        }
    }

}
