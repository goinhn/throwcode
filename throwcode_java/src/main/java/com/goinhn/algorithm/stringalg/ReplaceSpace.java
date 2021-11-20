package com.goinhn.algorithm.stringalg;

/**
 * <p>
 * 替换字符串中的空格
 * </p>
 *
 * @author goinhn
 * @date 2020-12-02T19:20:57
 */
public class ReplaceSpace {

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
    }
}
