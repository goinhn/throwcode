/*
 * Copyright (C) 2021 Baidu, Inc. All Rights Reserved.
 */
package com.goinhn.leetcode._1_100;

/**
 * 58.最后一个单词的长度
 *
 * @author goinhn
 * @date 2021-11-15
 **/
public class Sol58 {

    /**
     * time:O(n)
     * space:O(1)
     */
    private static class Solution1 {
        public int lengthOfLastWord(String s) {
            int lastLength = 0;
            int lastIndex = s.length() - 1;
            while (lastIndex > -1 && s.charAt(lastIndex) == ' ') {
                lastIndex--;
            }
            while (lastIndex > -1 && s.charAt(lastIndex) != ' ') {
                lastIndex--;
                lastLength++;
            }
            return lastLength;
        }
    }

}
