package com.goinhn.sworddirectoffer;

/**
 * <p>
 * 替换空格
 * <p>
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * <p>
 * complexity
 * time: O(n)
 * space: o(1)
 * </p>
 *
 * @author goinhn
 * @date 2020-12-05T14:30:25
 */
public class JZ02 {

    /**
     * 手动遍历循环实现
     */
    public static class ManualReplace {
        public static String replaceSpace(String target, String replace) {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < target.length(); i++) {
                if (target.charAt(i) == ' ') {
                    result.append(replace);
                } else {
                    result.append(target.charAt(i));
                }
            }

            return result.toString();
        }
    }

    /**
     * api进行替换
     */
    public static class ApiReplace {
        public static String replaceSpace(String target, String replace) {
            return target.replaceAll(" ", replace);
        }

        public static String replaceSpace(StringBuffer target, String replace) {
            return target.toString().replaceAll(" ", replace);
        }
    }
}