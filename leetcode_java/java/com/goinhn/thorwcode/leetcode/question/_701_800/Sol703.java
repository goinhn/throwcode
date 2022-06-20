package com.goinhn.thorwcode.leetcode.question._701_800;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 703. 数据流中的第 K 大元素
 *
 * @author goinhn
 * @date 2022/6/20
 */
public class Sol703 {

    /**
     * 队列
     */
    private static class Solution1 {

        private static class KthLargest {

            public int[] kNums;

            int size;

            /**
             * 利用k大小的数组来进行保存前k个大的元素
             * 来一个元素先判断是否能加入数组，不能加入前k个大的数组则直接返回原有的数组
             */
            public KthLargest(int k, int[] nums) {
                size = Math.min(nums.length, k);
                kNums = new int[k];
                Arrays.sort(nums);
                for (int i = 0; i < size; i++) {
                    kNums[i] = nums[nums.length - i - 1];
                }
            }

            /**
             * time:O(n)
             * space:O(n)
             */
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

            private void changeLocation() {
                for (int i = kNums.length - 1; i > 0; i--) {
                    if (kNums[i] > kNums[i - 1]) {
                        swap(kNums, i, i - 1);
                    } else {
                        break;
                    }
                }
            }

            private void swap(int[] arr, int x, int y) {
                int temp = arr[x];
                arr[x] = arr[y];
                arr[y] = temp;
            }

        }

    }


    /**
     * 小根堆
     */
    private static class Solution2 {

        private static class KthLargest {

            public int[] kNums;

            int size;

            /**
             * 利用小跟堆的结构（优先级队列）
             */
            public KthLargest(int k, int[] nums) {
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

            private void heapInsert(int[] arr, int index) {
                while (arr[index] < arr[index / 2]) {
                    swap(arr, index, index / 2);
                    index = index / 2;
                }
            }

            private void heapify(int[] arr, int index, int end) {
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

            private void swap(int[] arr, int x, int y) {
                int temp = arr[x];
                arr[x] = arr[y];
                arr[y] = temp;
            }

        }

    }

    /**
     * PriorityQueue
     */
    private static class Solution3 {

        private static class KthLargest {

            public PriorityQueue<Integer> minHeap;

            int size;

            int k;

            /**
             * 利用小跟堆的结构（优先级队列）
             */
            public KthLargest(int k, int[] nums) {
                this.k = k;
                minHeap = new PriorityQueue<>();
                size = Math.min(nums.length, k);
                Arrays.sort(nums);
                for (int i = 0; i < size; i++) {
                    minHeap.offer(nums[nums.length - i - 1]);
                }
            }

            public int add(int val) {
                if (size < k) {
                    minHeap.offer(val);
                    size++;
                } else {
                    if (minHeap.peek() < val) {
                        minHeap.poll();
                        minHeap.offer(val);
                    }
                }

                return minHeap.peek();
            }

        }

    }

}
