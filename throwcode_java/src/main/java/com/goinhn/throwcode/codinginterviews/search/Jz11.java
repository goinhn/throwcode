package com.goinhn.throwcode.codinginterviews.search;

/**
 * 11.旋转数组的最小数字
 *
 * @author goinhn
 * @date 2020-12-08T14:32:09
 */
public class Jz11 {

    /**
     * 遍历
     * time:O(n)
     * space:O(1)
     */
    private static class Solution1 {
        public int minArray(int[] numbers) {
            if (numbers == null || numbers.length == 0) {
                return 0;
            }

            for (int i = 0; i < numbers.length - 1; i++) {
                if (numbers[i] > numbers[i + 1]) {
                    return numbers[i + 1];
                }
            }

            return numbers[0];
        }
    }

    /**
     * 二分法
     * time:O(logn)
     * space:O(1)
     */
    private static class Solution2 {
        public int minArray(int[] numbers) {
            if (numbers == null || numbers.length == 0) {
                return 0;
            }

            int left = 0;
            int right = numbers.length - 1;
            while (left < right) {
                int middle = (left + right) >> 1;
                if (numbers[middle] < numbers[right]) {
                    right = middle;
                } else if (numbers[middle] > numbers[right]) {
                    left = middle + 1;
                } else {
                    right--;
                }
            }
            return numbers[right];
        }
    }
}
