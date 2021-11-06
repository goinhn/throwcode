package com.goinhn.leetcode._1_100;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 *
 * @author goinhn
 * @date 2020-08-29
 */
public class Sol1 {

    /**
     * 直接使用两遍循环判断是否有和等于目标值的数字
     * <p>
     * time:O(n^2)
     * space:O(1)
     */
    private static class Solution1 {
        public int[] twoSum(int[] nums, int target) {
            for (int i = 0; i < nums.length; i++) {
                int another = target - nums[i];
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] == another) {
                        return new int[]{i, j};
                    }
                }
            }

            throw new IllegalArgumentException("no two sum numbers");
        }
    }

    /**
     * 利用哈希表的结构来进行快速的查找
     * <p>
     * time:O(n)
     * space:O(n)
     */
    private static class Solution2 {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>(1);
            for (int i = 0; i < nums.length; i++) {
                map.put(nums[i], i);
            }
            for (int i = 0; i < nums.length; i++) {
                int temp = target - nums[i];
                if (map.containsKey(temp) && map.get(temp) != i) {
                    return new int[]{i, map.get(temp)};
                }
            }

            throw new IllegalArgumentException("no two sum numbers");
        }
    }

    /**
     * 利用哈希表的结构来进行快速的查找
     * <p>
     * time:O(n)
     * space:O(n)
     */
    private static class Solution3 {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int temp = target - nums[i];
                if (map.containsKey(temp)) {
                    return new int[]{i, map.get(temp)};
                }
                map.put(nums[i], i);
            }

            throw new IllegalArgumentException("no two sum numbers");
        }
    }

    /**
     * HashMap默认负载因子
     */
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    /**
     * 计算hashmap的合适初始化大小
     * expectedSize / 0.75F + 1.0F，取最近的稍大的二次方数
     */
    private static int calculateInitialCapacity(int elementSize) {
        int initTemp = (int) Math.floor(elementSize / DEFAULT_LOAD_FACTOR) + 1;
        return findTableSizeOf2(initTemp);
    }

    /**
     * 计算大于目标数的最小的2次方数
     */
    private static int findTableSizeOf2(int target) {
        if (target < 1) {
            return 0;
        }

        int temp2power = 1;
        while (temp2power < target) {
            temp2power *= 2;
        }
        return temp2power;
    }

    /**
     * 通过位操作来计算稍小和稍大于目标数的二次方数
     */
    private static int[] findNumSizeOf2(int target) {
        if (target < 1) {
            return null;
        }

        target |= target >>> 1;
        target |= target >>> 2;
        target |= target >>> 4;
        target |= target >>> 8;
        target |= target >>> 16;

        int max2Num = target + 1;
        int min2Num = max2Num >>> 1;
        return new int[]{min2Num, max2Num};
    }
}
