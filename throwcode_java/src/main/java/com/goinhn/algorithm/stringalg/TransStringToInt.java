package com.goinhn.algorithm.stringalg;

/**
 * <p>
 * 字符串转换为整数
 * <p>
 * 将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，但是string不符合数字要求时返回0)，
 * 要求不能使用字符串转换整数的库函数。
 * 数值为0或者字符串不是一个合法的数值则返回0。
 * </p>
 *
 * @author goinhn
 * @date 2020-12-03T16:26:54
 */
public class TransStringToInt {

    public static int StrToInt(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }

        char[] chars = str.toCharArray();
//        判断符号标志
        int flag = 0;
        if (chars[0] == '-') {
            flag = -1;
        } else if (chars[0] == '+') {
            flag = 1;
        } else if (!Character.isDigit(chars[0])) {
            return 0;
        }

        int start = flag == 0 ? 0 : 1;
        int result = 0;
        for (int i = start; i < str.length(); i++) {
//            对每一个位置的进行判断是否为数字，为数字则添加进结果中
            if (Character.isDigit(chars[i])) {
                result = result * 10 + (chars[0] - '0');
            } else {
                return 0;
            }
        }

        return flag == 0 ? result : flag * result;
    }

}
