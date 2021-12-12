package com.goinhn.thorwcode.leetcode.question._201_300;

import java.util.HashMap;
import java.util.Map;

/**
 * 219.存在重复元素
 *
 * @author goinhn
 * @date 2021/12/9
 */
public class Sol219 {

    /**
     * 哈希表
     * <p>
     * time:O(n)
     * space:O(n)
     */
    private static class Solution1 {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            Map<Integer, Integer> indexMap = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                Integer index = indexMap.get(nums[i]);
                if (null != index && i - index <= k) {
                    return true;
                }
                indexMap.put(nums[i], i);
            }
            return false;
        }
    }
}
