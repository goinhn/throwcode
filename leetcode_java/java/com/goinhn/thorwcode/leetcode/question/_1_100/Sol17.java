package com.goinhn.thorwcode.leetcode.question._1_100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17.电话号码的字母组合
 *
 * @author goinhn
 * @date 2022/6/23
 */
public class Sol17 {

    /**
     * 回溯
     * time:O(3^m * 4^n)
     * space:O(m + n)
     */
    private static class Solution1 {

        private Map<String, String> phone = new HashMap<String, String>() {
            {
                put("2", "abc");
                put("3", "def");
                put("4", "ghi");
                put("5", "jkl");
                put("6", "mno");
                put("7", "pqrs");
                put("8", "tuv");
                put("9", "wxyz");
            }
        };

        private List<String> output;

        public List<String> letterCombinations(String digits) {
            if (digits == null || digits.length() == 0) {
                return Collections.emptyList();
            }

            output = new ArrayList();

            backtrack("", digits, 0);

            return output;
        }

        public void backtrack(String combination, String digits, int index) {
            // 遍历到最后一个情况
            if (index == digits.length()) {
                output.add(combination);
                return;
            }

            String digit = digits.substring(index, index + 1);
            String letters = phone.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                backtrack(combination + letters.charAt(i), digits, index + 1);
            }
        }

    }

}
