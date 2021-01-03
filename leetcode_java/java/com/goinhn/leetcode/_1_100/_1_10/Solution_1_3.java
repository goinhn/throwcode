package com.goinhn.leetcode._1_100._1_10;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 1. 两数之和
 * <p>
 * 时间复杂度O(N)
 * 空间复杂度O(N)
 * <p>
 * 利用哈希表的结构来进行快速的查找
 * </p>
 *
 * @author goinhn
 * @date 2020-08-29T20:05:54
 */
public class Solution_1_3 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp)) {
                return new int[]{i, map.get(temp)};
            }
            map.put(nums[i], i);
        }

        throw new IllegalArgumentException("no two sum");
    }

    public static void main(String[] args) {

    }

}
