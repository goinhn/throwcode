package com.goinhn.leetcode._1_100;

import java.util.*;

/**
 * <p>
 * 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 时间复杂度:O(n^2)
 * 空间复杂度O(1)
 * </p>
 *
 * @author goinhn
 * @date 2020-09-15T16:54:10
 */
public class Solution_15_2 {

    /**
     * 先对数组进行排序，再选择一个数字作为基准，剩下两个数字从左右开始移动指针来进行比较是不是三个相加为零，遇到重复的数字，指针跳过即可
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int temp = 0 - nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (left > i + 1 && nums[left] == nums[left - 1]) {
                    left++;
                    continue;
                }

                if (right < nums.length - 1 && nums[right] == nums[right + 1]) {
                    right--;
                    continue;
                }

                if (nums[left] + nums[right] > temp) {
                    right--;
                } else if (nums[left] + nums[right] < temp) {
                    left++;
                } else {
                    List<Integer> list = Arrays.asList(nums[i], nums[left], nums[right]);
                    lists.add(list);
                    left++;
                    right--;
                }
            }
        }

        return lists;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 0, -2, -1, 1, 2};

        System.out.println(threeSum(nums));

    }

}
