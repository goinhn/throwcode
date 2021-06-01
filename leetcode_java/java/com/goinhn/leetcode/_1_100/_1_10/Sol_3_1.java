package com.goinhn.leetcode._1_100._1_10;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 3. 无重复字符的最长字串
 * <p>
 * time:O(n)
 * space:O(n)
 * </p>
 * 滑动窗口
 *
 * @author goinhn
 * @date 2021-06-01
 */
public class Sol_3_1 {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        // 左右指针
        int leftIndex = 0;
        int rightIndex = 1;

        // 记录不重复的相邻位置和元素
        Map<Character, Integer> charMap = new HashMap<>();
        charMap.put(s.charAt(0), 0);
        int max = 1;
        while (rightIndex < s.length() && max < s.length() - leftIndex) {
            if (!charMap.containsKey(s.charAt(rightIndex))) {
                max = Math.max(max, rightIndex - leftIndex + 1);

            // 如果右指针存在重复则将左指针跳过重复的位置
            } else {
                int middleIndex = charMap.get(s.charAt(rightIndex));
                for (int i = leftIndex; i < middleIndex + 1; i++) {
                    charMap.remove(s.charAt(i));
                }
                leftIndex = middleIndex + 1;
            }
            charMap.put(s.charAt(rightIndex), rightIndex);
            rightIndex++;
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Sol_3_1().lengthOfLongestSubstring("pwwkew"));
    }

}
