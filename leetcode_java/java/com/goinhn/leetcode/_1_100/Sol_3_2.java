package com.goinhn.leetcode._1_100;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>
 * 3. 无重复字符的最长子串
 * <p>
 * time:O(n^3)
 * space:O(n)
 * <p>
 * 暴力法：三遍循环
 * </p>
 *
 * @author goinhn
 * @date 2021-06-01
 */
public class Sol_3_2 {

    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() ==0) {
            return 0;
        }

        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (allUnique(s, i, j)) {
                    maxLength = Math.max(maxLength, j - i);
                }
            }
        }

        return maxLength;
    }

    public boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            if (set.contains(s.charAt(i))) {
                return false;
            }
            set.add(s.charAt(i));
        }
        return true;
    }

    public static void main(String[] args) {
        String test = "abdcdkafkajfkahfkh";
        System.out.println(new Sol_3_2().lengthOfLongestSubstring(test));
    }

}
