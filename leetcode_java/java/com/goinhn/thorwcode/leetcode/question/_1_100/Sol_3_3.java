package com.goinhn.thorwcode.leetcode.question._1_100;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>
 * 3. 无重复字符的最长子串
 * <p>
 * time:O(n)
 * space:O(n)
 * <p>
 * 滑动窗口
 * </p>
 *
 * @author goinhn
 * @date 2021-06-01
 */
public class Sol_3_3 {

    public int lengthOfLongestSubstring(String s) {
        int strLength = s.length();
        int start = 0, end = 0;
        int maxLength = 0;
        Set<Character> set = new HashSet<>();

        while(start < strLength && end < strLength && maxLength < strLength - start - 1) {
            if(!set.contains(s.charAt(end))) {
                set.add(s.charAt(end));
                end++;
                maxLength = Math.max(maxLength, end - start);
            }else {
                set.remove(s.charAt(start));
                start++;
            }
        }

        return maxLength;
    }

}
