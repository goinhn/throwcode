package com.goinhn.leetcode._1_100._11_20;

import java.util.*;

/**
 * <p>
 * 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 时间复杂度:O(n^2)
 * 空间复杂度O(n)
 * </p>
 *
 * @author goinhn
 * @date 2020-09-15T16:54:10
 */
public class Solution_15_1 {

    /**
     * 使用map的方法来进行判断，没有办法消除数组中本身存在的重复数字
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numMap.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int temp = 0 - nums[i] - nums[j];
                if (numMap.containsKey(temp) && numMap.get(temp) > j) {
                    List<Integer> list = Arrays.asList(nums[i], nums[j], temp);
                    lists.add(list);
                }
            }
        }

        return lists;
    }

}
