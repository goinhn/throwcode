package com.goinhn.throwcode.codinginterviews.bit_operation;

import java.util.HashMap;
import java.util.Map;

/**
 * 56II. 数组中数字出现的次数 II
 *
 * @author goinhn
 * @date 2022/6/16
 */
public class Jz56II {

    /**
     * hash映射
     * time:O(n)
     * space:O(n)
     */
    private static class Solution1 {

        public int singleNumber(int[] nums) {
            Map<Integer, Integer> countMap = new HashMap<>();
            for (int num : nums) {
                countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            }

            for (Integer num : countMap.keySet()) {
                if (countMap.get(num) == 1) {
                    return num;
                }
            }

            return -1;
        }

    }

    /**
     * 位操作
     * 每个位上的1的个数一定是出线次数的倍数，最后剩下的则为出现一次的数字
     * time:O(n)
     * space:O(n)
     */
    private static class Solution2 {

        public int singleNumber(int[] nums) {
            // 将每一位和的情况统计当前的数组上
            int[] sumCounts = new int[32];
            for (int num : nums) {
                for (int i = 0; i < 32; i++) {
                    sumCounts[i] += num & 1;
                    num >>>= 1;
                }
            }

            // 从数组中取出对3取余
            int res = 0;
            for (int i = 0; i < 32; i++) {
                res += (sumCounts[i] % 3) << i;
            }

            return res;
        }

    }

}
