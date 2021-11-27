package com.goinhn.thorwcode.leetcode.question._101_200;

import java.util.Random;

/**
 * 157.用户Read4读取N个字符
 *
 * @author goinhn
 * @date 2021/11/27
 */
public class Sol157 {

    private static class Solution1 {
        public int read4(char[] buf) {
            return new Random().nextInt(3) + 1;
        }

        public int read(char[] buf, int n) {
            int tmp;
            int length = 0;
            char[] bufTmp = new char[4];
            while ((tmp = read4(bufTmp)) != 0) {
                for (int i = 0; i < tmp && length < n; i++) {
                    buf[length] = bufTmp[i];
                    length++;
                }
            }
            return length;
        }
    }
}
