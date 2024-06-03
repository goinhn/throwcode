package com.goinhn.thorwcode.leetcode.question._401_500;

import java.util.HashMap;
import java.util.Map;

/**
 * 494.目标和
 *
 * @author goinhn
 * @date 2023/1/4
 */
public class Sol494 {

    /**
     * 递归回溯
     * time:O(2^n)
     * space:O(1)
     */
    private static class Solution1 {
        public int findTargetSumWays(int[] nums, int target) {
            return dfs(nums, 0, 0, target);
        }

        private int dfs(int[] nums, int i, int sum, int target) {
            if (i < nums.length - 1) {
                return dfs(nums, i + 1, sum + nums[i], target)
                        + dfs(nums, i + 1, sum - nums[i], target);
            }

            // 0可以存在两种符号情况
            if (sum == target && nums[i] == 0) {
                return 2;
            } else if (sum + nums[i] == target || sum - nums[i] == target) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    /**
     * 记忆化搜索
     * time:O(2^n)
     * space:O(1)
     */
    private static class Solution2 {
        private Map<String, Integer> cache;

        public int findTargetSumWays(int[] nums, int target) {
            cache = new HashMap<>();
            return dfs(nums, 0, 0, target);
        }

        private int dfs(int[] nums, int i, int sum, int target) {
            if (cache.containsKey(key(i, sum))) {
                return cache.get(key(i, sum));
            }
            if (i < nums.length - 1) {
                int count = dfs(nums, i + 1, sum + nums[i], target)
                        + dfs(nums, i + 1, sum - nums[i], target);
                cache.put(i + "-" + sum, count);
                return count;
            }

            // 0可以存在两种符号情况
            int count = 0;
            if (sum == target && nums[i] == 0) {
                count = 2;
            } else if (sum + nums[i] == target || sum - nums[i] == target) {
                count = 1;
            }
            cache.put(key(i, sum), count);
            return count;
        }

        private String key(int i, int sum) {
            return i + "-" + sum;
        }
    }

    /**
     * 动态规划
     * time:O()
     * space:O()
     */
    private static class Solution3 {
        public int findTargetSumWays(int[] nums, int t) {
            int n = nums.length;
            int s = 0;
            for (int i : nums) {
                s += Math.abs(i);
            }
            if (Math.abs(t) > s) {
                return 0;
            }

            int[][] f = new int[n + 1][2 * s + 1];
            f[0][s] = 1;
            for (int i = 1; i <= n; i++) {
                int x = nums[i - 1];
                for (int j = -s; j <= s; j++) {
                    if ((j - x) + s >= 0) {
                        f[i][j + s] += f[i - 1][(j - x) + s];
                    }
                    if ((j + x) + s <= 2 * s) {
                        f[i][j + s] += f[i - 1][(j + x) + s];
                    }
                }
            }
            return f[n][t + s];
        }
    }


}
