package com.goinhn.thorwcode.leetcode.question._101_200;

import java.util.HashMap;
import java.util.Map;

/**
 * 169.多数元素
 *
 * @author goinhn
 * @date 2021/11/29
 */
public class Sol169 {

    /**
     * 哈希表
     * <p>
     * time:O(n)
     * space:O(n)
     */
    private static class Solution1 {
        public int majorityElement(int[] nums) {
            Map<Integer, Integer> numCountMap = new HashMap<>();
            for (int num : nums) {
                int nowCount = numCountMap.getOrDefault(num, 0) + 1;
                if (nowCount > nums.length / 2) {
                    return num;
                }
                numCountMap.put(num, nowCount);
            }
            return -1;
        }
    }

    /**
     * 摩尔投票法
     * <p>
     * time:O(n)
     * space:O(1)
     */
    private static class Solution2 {
        public int majorityElement(int[] nums) {
            int voteNum = nums[0];
            int voteCount = 1;
            for (int i = 1; i < nums.length; i++) {
                if (voteNum == nums[i]) {
                    voteCount++;
                } else {
                    voteCount--;
                    if (voteCount == 0) {
                        voteNum = nums[i];
                        voteCount = 1;
                    }
                }
            }
            return voteNum;
        }
    }

}
