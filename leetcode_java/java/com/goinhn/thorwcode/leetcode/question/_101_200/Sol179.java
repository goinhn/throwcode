package com.goinhn.thorwcode.leetcode.question._101_200;

import java.util.Arrays;

/**
 * 179.最大数
 *
 * @author goinhn
 * @date 2022/10/11
 */
public class Sol179 {

    /**
     * 比较排序位置，定义排序规则
     * time:O(nlogn)
     * space:O(1)
     */
    private static class Solution1 {

        public String largestNumber(int[] nums) {
            String[] strS = new String[nums.length];
            for (int i = 0; i < nums.length; i++) {
                strS[i] = String.valueOf(nums[i]);
            }
            Arrays.sort(strS, (x, y) -> (y + x).compareTo(x + y));
            StringBuilder sb = new StringBuilder();
            for (String str : strS) {
                sb.append(str);
            }

            int idx = 0;
            while (idx < sb.length() - 1 && sb.charAt(idx) == '0') {
                idx++;
            }
            return sb.substring(idx);
        }

    }
}
