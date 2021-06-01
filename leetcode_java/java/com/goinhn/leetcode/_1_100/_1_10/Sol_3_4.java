package com.goinhn.leetcode._1_100._1_10;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 3. 无重复字符的最长子串
 * <p>
 * time:O(n)
 * space:O(n)
 * <p>
 * hashmap增加下标优化滑动窗口
 * </p>
 *
 * @author goinhn
 * @date 2021-06-01
 */
public class Sol_3_4 {

    public static void main(String[] args) {
        String test = "dvdf";
        System.out.println(new Sol_3_4().lengthOfLongestSubstring(test));
    }

    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0;
        int strLength = s.length();
        int maxLength = 0;
        Map<Character, Integer> map = new HashMap<>();

        while(right < strLength) {
            if(map.containsKey(s.charAt(right))) {
                left = Math.max(map.get(s.charAt(right)), left);
            }
            maxLength = Math.max(maxLength, right - left + 1);
            map.put(s.charAt(right), right + 1);
            right++;
        }

        return maxLength;
    }


}
