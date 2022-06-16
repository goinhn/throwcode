package com.goinhn.thorwcode.leetcode.question._501_600;

import java.util.HashMap;
import java.util.Map;

/**
 * 532.数组中的 k-diff 数对
 *
 * @author goinhn
 * @date 2022/6/16
 */
public class Sol532 {

    /**
     * 哈希表
     * <p>
     * time:O(n)
     * space:O(n)
     */
    private static class Solution1 {

        public int findPairs(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            int count = 0;
            for (int num : nums) {
                if (!map.containsKey(num)) {
                    continue;
                }

                if (k == 0) {
                    if (map.get(num) > 1) {
                        count++;
                    }
                } else {
                    if (map.containsKey(num - k)) {
                        count++;
                    }
                    if (map.containsKey(num + k)) {
                        count++;
                    }
                }

                map.remove(num);
            }

            return count;
        }

    }

}
