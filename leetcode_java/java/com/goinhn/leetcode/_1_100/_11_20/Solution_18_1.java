package com.goinhn.leetcode._1_100._11_20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author goinhn
 * @date 2020-09-15T17:55:47
 */
public class Solution_18_1 {

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int three = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int two = three - nums[j];
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    if (left > j + 1 && nums[left] == nums[left - 1]) {
                        left++;
                        continue;
                    }

                    if (right < nums.length - 1 && nums[right] == nums[right + 1]) {
                        right--;
                        continue;
                    }

                    if (nums[left] + nums[right] > two) {
                        right--;
                    } else if (nums[left] + nums[right] < two) {
                        left++;
                    } else {
                        List<Integer> list = Arrays.asList(nums[i], nums[j], nums[left], nums[right]);
                        lists.add(list);
                        left++;
                        right--;
                    }
                }
            }
        }

        return lists;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, -2, -5, -4, -3, 3, 3, 5};

        System.out.println(fourSum(nums, -11));

    }

}
