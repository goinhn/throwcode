package com.goinhn.throwcode.codinginterviews.sort;

import java.util.Arrays;

/**
 * 45.把数组排成最小的数
 *
 * @author goinhn
 * @date 2022/1/10
 */
public class Jz45 {

    /**
     * 排序规则：
     * 若拼接字符串 x+y>y+x ，则 x “大于” y ；
     * 反之，若 x+y<y+x ，则 x “小于” y ；
     * <p>
     * time:O(nlogn)
     * space:O(1)
     */
    private static class Solution1 {
        public String minNumber(int[] nums) {
            String[] numsStr = new String[nums.length];
            for (int i = 0; i < nums.length; i++) {
                numsStr[i] = String.valueOf(nums[i]);
            }

            Arrays.sort(numsStr, (x, y) -> (x + y).compareTo(y + x));

            StringBuilder res = new StringBuilder();
            for (String num : numsStr) {
                res.append(num);
            }

            return res.toString();
        }
    }
}

