package com.goinhn.throwcode.codinginterviews.dynamic_programming;

import java.util.HashMap;
import java.util.Map;

/**
 * 48.最长不含重复字符的子字符串
 *
 * @author goinhn
 * @date 2022/1/8
 */
public class Jz48 {

    /**
     * 动态规划
     * time:O(n)
     * space:O(n)
     */
    private static class Solution1 {
        public int lengthOfLongestSubstring(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }
            Map<Character, Integer> indexMap = new HashMap<>();
            int[] dp = new int[s.length()];
            dp[0] = 1;
            indexMap.put(s.charAt(0), 0);
            int maxLength = 1;
            for (int i = 1; i < dp.length; i++) {
                int leftIndex = indexMap.getOrDefault(s.charAt(i), -1);
                indexMap.put(s.charAt(i), i);
                dp[i] = dp[i - 1] < i - leftIndex ? dp[i - 1] + 1 : i - leftIndex;
                maxLength = Math.max(dp[i], maxLength);
            }
            return maxLength;
        }
    }

    /**
     * 动态规划
     * time:O(n)
     * space:O(1)
     */
    private static class Solution2 {
        public int lengthOfLongestSubstring(String s) {
            Map<Character, Integer> indexMap = new HashMap<>();
            int maxLength = 0;
            int dpNum = 0;
            for (int i = 0; i < s.length(); i++) {
                int leftIndex = indexMap.getOrDefault(s.charAt(i), -1);
                indexMap.put(s.charAt(i), i);
                dpNum = dpNum < i - leftIndex ? dpNum + 1 : i - leftIndex;
                maxLength = Math.max(dpNum, maxLength);
            }
            return maxLength;
        }
    }

    /**
     * 双指针
     * time:O(n)
     * space:O(1)
     */
    private static class Solution3 {
        public int lengthOfLongestSubstring(String s) {
            Map<Character, Integer> indexMap = new HashMap<>();
            int i = -1, res = 0;
            for (int j = 0; j < s.length(); j++) {
                if (indexMap.containsKey(s.charAt(j))) {
                    i = Math.max(i, indexMap.get(s.charAt(j)));
                }
                indexMap.put(s.charAt(j), j);
                res = Math.max(res, j - i);
            }
            return res;
        }
    }

}

