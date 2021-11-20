package com.goinhn.interview._2020._20200925_zhaoyinwangluokeji;

/**
 * <p>
 * 招银网络科技，判断字符串是否是对称的
 * </p>
 *
 * @author goinhn
 * @date 2020-09-26T12:50:30
 */
public class Main_1 {

    public static void main(String[] args) {
        String test = "aba";
        System.out.println(isSymmetry(test));
    }

    /**
     * 左右指针往中间移动观察每次移动后对应位置的字符是否相等
     *
     * @param str
     * @return
     */
    public static boolean isSymmetry(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

}
