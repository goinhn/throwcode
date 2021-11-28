/*
 * Copyright (C) 2021 Baidu, Inc. All Rights Reserved.
 */
package com.goinhn.thorwcode.leetcode.question._101_200;

/**
 * 167.两数之和II - 输入有序数组
 *
 * @author goinhn
 * @date 2021/11/28
 */
public class Sol167 {

    private static class Solution1 {
        public int[] twoSum(int[] numbers, int target) {
            int left = 0;
            int right = numbers.length - 1;
            while (left < right) {
                if (numbers[left] + numbers[right] < target) {
                    left++;
                } else if (numbers[left] + numbers[right] > target) {
                    right--;
                } else {
                    return new int[]{left + 1, right + 1};
                }
            }
            return new int[]{-1, -1};
        }
    }
}
