package com.goinhn.thorwcode.leetcode.question._101_200;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 多数元素
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于⌊ n/2 ⌋的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 * 示例 1:
 * 输入: [3,2,3]
 * 输出: 3
 * <p>
 * 示例 2:
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 * </p>
 *
 * @author goinhn
 * @date 2020-12-21T23:37:24
 */
public class Solution_169_2 {

    /**
     * 分治递归思想
     * 存在问题
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int[] result = majorityElementHelper(nums, 0, nums.length);
        return result == null ? -1 : result[0];
    }

    public int[] majorityElementHelper(int[] nums, int left, int right) {
        if (right - left < 1) {
            return null;
        }

        if (right - left < 2) {
            return new int[]{nums[0], 1};
        }

        if (nums.length < 3) {
            if (nums[0] == nums[1]) {
                return new int[]{nums[0], 2};
            } else {
                return null;
            }
        }

        int middle = (right + left) / 2;
        int[] leftNums = majorityElementHelper(nums, left, middle);
        int[] rightNums = majorityElementHelper(nums, middle + 1, right);
        if (leftNums == null && rightNums == null) {
            return null;
        } else if (leftNums == null && rightNums != null) {
            return rightNums;
        } else if (leftNums != null && rightNums == null) {
            return leftNums;
        } else {
            if (leftNums[0] == rightNums[0]) {
                return new int[]{leftNums[0], leftNums[1] + rightNums[1]};
            } else {
                if (leftNums[1] > rightNums[1]) {
                    return leftNums;
                } else {
                    return rightNums;
                }
            }
        }
    }

}
