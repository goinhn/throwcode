package com.goinhn.thorwcode.leetcode.question._801_900;

/**
 * <p>
 * 利用双指针从右往左进行判断，遇到多少的退格符号就跳过多少的
 * <p>
 * 时间复杂度:O(M+N)
 * 空间复杂度:O(1)
 * </p>
 *
 * @author goinhn
 * @date 2020-09-12T20:24:36
 */
public class Solution_844_2 {

    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1;
        int j = T.length() - 1;
        int backspace = 0;

        while (i >= 0 || j >= 0) {
            // 根据退格的个数来进行退格
            while (i >= 0) {
                if (S.charAt(i) == '#') {
                    backspace++;
                    i--;
                } else if (backspace > 0) {
                    backspace--;
                    i--;
                } else {
                    break;
                }
            }

            while (j >= 0) {
                if (T.charAt(j) == '#') {
                    backspace++;
                    j--;
                } else if (backspace > 0) {
                    backspace--;
                    j--;
                } else {
                    break;
                }
            }

            // 判断没有退给的字符是否相等
            if (i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j)) {
                return false;
            }

            // 如果存在其中一个跑完另一个没有跑完的话就判断失败
            if ((i >= 0) != (j >= 0)) {
                return false;
            }

            i--;
            j--;
        }

        return true;
    }

}
