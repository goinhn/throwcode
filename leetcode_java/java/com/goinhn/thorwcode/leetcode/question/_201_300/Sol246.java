package com.goinhn.thorwcode.leetcode.question._201_300;

import java.util.HashMap;
import java.util.Map;

/**
 * 246.中心对称数
 *
 * @author goinhn
 * @date 2021/12/13
 */
public class Sol246 {

    private static class Solution1 {
        private final Map<Character, Character> mapping;
        private int count = 0;

        public Solution1() {
            mapping = new HashMap<>();
            mapping.put('0', '0');
            mapping.put('1', '1');
            mapping.put('6', '9');
            mapping.put('8', '8');
            mapping.put('9', '6');
        }

        public int symmetryNumInRange(String low, String high) {
            isSymmetryNum(low);
            isSymmetryNum(high);
            return count;
        }

        /**
         * 是否是对称数
         */
        public boolean isSymmetryNum(String num) {
            if (null == num || 0 == num.length()) {
                return true;
            }
            int left = 0;
            int right = num.length() - 1;
            while (left < right) {
                if (mapping.get(num.charAt(left)) != num.charAt(right)) {
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }
    }
}
