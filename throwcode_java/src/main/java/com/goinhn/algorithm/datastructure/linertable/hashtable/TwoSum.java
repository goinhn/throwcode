package com.goinhn.algorithm.datastructure.linertable.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * leetcode 1
 * <p>
 * 两数之和
 * </p>
 *
 * @author goinhn
 * @date 2020-08-29T17:00:48
 */
public class TwoSum {

    /**
     * time:O(n^2)
     * spaceO(1)
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int another = target - nums[i];
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == another) {
                    return new int[]{i, j};
                }
            }
        }

        throw new IllegalArgumentException("no two sum number");
    }

    /**
     * time:O(n)
     * space:O(n)
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSumMap(int[] nums, int target) {
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

        throw new IllegalArgumentException("no two sum");
    }

    /**
     * time:O(n)
     * space:O(n)
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSumMapAdvanced(int[] nums, int target) {
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

}
