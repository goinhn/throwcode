package com.goinhn.interview._2020._20201009_haier;

/**
 * <p>
 * 海尔笔试
 * <p>
 * 计算密码
 * 计算一个整数的各个位数的乘积
 * </p>
 *
 * @author goinhn
 * @date 2020-10-09T14:08:35
 */
public class Main_1 {

    public static void main(String[] args) {

    }

    public static int getNum(int num) {
        int result = 1;
        while (num > 0) {
            int temp = result % 10;
            result *= temp;
            num = num / 10;
        }

        return result;
    }

}
