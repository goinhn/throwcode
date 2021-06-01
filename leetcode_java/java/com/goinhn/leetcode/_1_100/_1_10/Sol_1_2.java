package com.goinhn.leetcode._1_100._1_10;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 1. 两数之和
 * <p>
 * time:O(N)
 * space:O(N)
 * <p>
 * 利用哈希表的结构来进行快速的查找
 * </p>
 *
 * @author goinhn
 * @date 2020-08-29
 */
public class Sol_1_2 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
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

    public static void main(String[] args) {

    }

}
