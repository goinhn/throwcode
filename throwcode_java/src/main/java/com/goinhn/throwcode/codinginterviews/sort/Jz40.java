package com.goinhn.throwcode.codinginterviews.sort;

import java.util.PriorityQueue;

/**
 * 40.最小的k个数
 *
 * @author goinhn
 * @date 2022/4/13
 */
public class Jz40 {

    /**
     * 选择排序
     * time:O(n^2)
     * space:O(1)
     */
    private static class Solution1 {
        public int[] getLeastNumbers(int[] arr, int k) {
            if (arr == null || k == 0) {
                return new int[0];
            }

            for (int i = 0; i < k; i++) {
                int minIndex = i;
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[minIndex] > arr[j]) {
                        minIndex = j;
                    }
                }
                swap(arr, i, minIndex);
            }

            int[] res = new int[k];
            System.arraycopy(arr, 0, res, 0, k);
            return res;
        }

        /**
         * change num location
         */
        private void swap(int[] arr, int x, int y) {
            int temp = arr[x];
            arr[x] = arr[y];
            arr[y] = temp;
        }
    }

    /**
     * 小顶堆
     * time:O(nlogn)
     * space:O(1)
     */
    private static class Solution2 {
        public int[] getLeastNumbers(int[] arr, int k) {
            if (arr == null || k == 0) {
                return new int[0];
            }

            for (int i = 0; i < arr.length; i++) {
                heapInsert(arr, i);
            }

            int end = arr.length;
            swap(arr, 0, --end);
            int boundaries = Math.max(arr.length - k - 1, 0);
            while (end > boundaries) {
                heapify(arr, 0, end);
                swap(arr, 0, --end);
            }

            int[] res = new int[k];
            for (int i = arr.length - 1; i > arr.length - k - 1; i--) {
                res[arr.length - i - 1] = arr[i];
            }
            return res;
        }

        /**
         * 构建小根堆
         */
        private void heapInsert(int[] arr, int index) {
            while (arr[index] < arr[(index - 1) / 2]) {
                swap(arr, index, (index - 1) / 2);
                index = (index - 1) / 2;
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

                swap(arr, smallest, index);
                index = smallest;
                left = index * 2 + 1;
            }
        }

        /**
         * change num location
         */
        private void swap(int[] arr, int x, int y) {
            int temp = arr[x];
            arr[x] = arr[y];
            arr[y] = temp;
        }
    }

    /**
     * 自带堆结构，大顶堆
     * time:O(nlogn)
     * space:O(n)
     */
    private static class Solution3 {
        public int[] getLeastNumbers(int[] arr, int k) {
            if (arr == null || k == 0) {
                return new int[0];
            }

            int[] res = new int[k];
            PriorityQueue<Integer> queue = new PriorityQueue<>((num1, num2) -> num2 - num1);
            for (int i = 0; i < k; ++i) {
                queue.offer(arr[i]);
            }
            for (int i = k; i < arr.length; ++i) {
                if (queue.peek() > arr[i]) {
                    queue.poll();
                    queue.offer(arr[i]);
                }
            }
            for (int i = 0; i < k; ++i) {
                res[i] = queue.poll();
            }
            return res;
        }
    }
}

