package com.goinhn.throwcode.codinginterviews.search_backtracking;

import java.util.HashMap;
import java.util.Map;

/**
 * 39.数组中出现次数超过一半的数字
 *
 * @author goinhn
 * @date 2022/4/12
 */
public class Jz39 {

    /**
     * 哈希表
     * time:O(n)
     * space:O(n)
     */
    private static class Solution1 {
        public int majorityElement(int[] nums) {
            int halfNum = nums.length / 2;
            Map<Integer, Integer> numMap = new HashMap<>();
            for (int num : nums) {
                int count = numMap.getOrDefault(num, 0) + 1;
                if (count > halfNum) {
                    return num;
                }
                numMap.put(num, count);
            }
            return -1;
        }
    }

    /**
     * 投票算法
     * time:O(n)
     * space:O(n)
     */
    private static class Solution2 {
        public int majorityElement(int[] nums) {
            int candidate = 0;
            int count = 0;
            for (int num : nums) {
                if (count == 0) {
                    candidate = num;
                }
                count += candidate == num ? 1 : -1;
            }
            return candidate;
        }
    }
}

