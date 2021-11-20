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
public class Solution_169_1 {

    /**
     * 使用map进行计数，当某个数字的次数超过数组长度的一半的时候，该数字就是众数
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int count = map.getOrDefault(nums[i], 0) + 1;
            if (count > nums.length / 2) {
                return nums[i];
            }

            map.put(nums[i], count);
        }

        return -1;
    }

}
