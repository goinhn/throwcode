package com.goinhn.thorwcode.leetcode.question._1101_1200;

/**
 * 1108.IP地址无效化
 *
 * @author goinhn
 * @date 2022/6/21
 */
public class Sol1108 {

    /**
     * 正则替换
     * time:O(1)
     * space:O(1)
     */
    private static class Solution1 {

        private static final String DOT_REGEX = "\\.";

        private static final String REPLACEMENT_STR = "[.]";

        public String defangIPaddr(String address) {
            return address.replaceAll(DOT_REGEX, REPLACEMENT_STR);
        }

    }

}
