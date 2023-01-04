package com.goinhn.thorwcode.leetcode.question._401_500;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 464.我能赢吗
 *
 * @author goinhn
 * @date 2023/1/3
 */
public class Sol464 {

    /**
     * 递归搜索
     * time:O(n * 2^n)
     * space:O(n * 2^n)
     */
    private static class Solution1 {
        public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
            if (maxChoosableInteger >= desiredTotal) {
                return true;
            }
            if ((1 + maxChoosableInteger) * maxChoosableInteger / 2 < desiredTotal) {
                return false;
            }
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < maxChoosableInteger; i++) {
                set.add(i + 1);
            }
            return dfs(0, set, desiredTotal);
        }

        private boolean dfs(int sum, Set<Integer> set, int desiredTotal) {
            for (Integer num : set) {
                if (sum + num >= desiredTotal) {
                    return true;
                }
                Set<Integer> newSet = new HashSet<>(set);
                newSet.remove(num);
                if (!dfs(sum + num, newSet, desiredTotal)) {
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * 使用位操作来减少存储空间占用
     *
     * time:O(n * 2^n)
     * space:O(2^n)
     */
    private static class Solution2 {
        public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
            if (maxChoosableInteger >= desiredTotal) {
                return true;
            }
            if ((1 + maxChoosableInteger) * maxChoosableInteger / 2 < desiredTotal) {
                return false;
            }
            return dfs(0, 0, maxChoosableInteger, desiredTotal);
        }

        private boolean dfs(int sum, int set, int m, int d) {
            for (int i = 0; i < m; i++) {
                int lo = 1 << i;
                if ((lo & set) == 1) {
                    continue;
                }
                if (sum + i + 1 >= d) {
                    return true;
                }

                if (!dfs(sum + i + 1, set | lo, m, d)) {
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * 增加过程结果缓存，记忆化搜索
     *
     * time:O(n * 2^n)
     * space:O(2^n)
     */
    private static class Solution3 {

        /**
         * 缓存中间结果使用
         */
        private Map<Integer, Boolean> cache;

        public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
            if (maxChoosableInteger >= desiredTotal) {
                return true;
            }
            if ((1 + maxChoosableInteger) * maxChoosableInteger / 2 < desiredTotal) {
                return false;
            }
            cache = new HashMap<>();
            return dfs(0, 0, maxChoosableInteger, desiredTotal);
        }

        private boolean dfs(int sum, int set, int m, int d) {
            if (cache.containsKey(set)) {
                return cache.get(set);
            }
            for (int i = 0; i < m; i++) {
                int lo = 1 << i;
                if ((lo & set) == 1) {
                    continue;
                }
                if (sum + i + 1 >= d) {
                    cache.put(sum, true);
                    return true;
                }

                if (!dfs(sum + i + 1, set | lo, m, d)) {
                    cache.put(sum, true);
                    return true;
                }
            }
            cache.put(sum, false);
            return false;
        }
    }

}
