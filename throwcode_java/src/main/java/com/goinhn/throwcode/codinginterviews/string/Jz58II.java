package com.goinhn.throwcode.codinginterviews.string;

/**
 * 58II.左旋转字符串
 *
 * @author goinhn
 * @date 2021/12/24
 */
public class Jz58II {

    private static class Solution1 {
        public String reverseLeftWords(String s, int n) {
            return s.substring(n) + s.substring(0, n);
        }
    }
}
