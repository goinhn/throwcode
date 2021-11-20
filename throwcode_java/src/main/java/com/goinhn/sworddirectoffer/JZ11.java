package com.goinhn.sworddirectoffer;

/**
 * <p>
 * 二进制中的个数
 * <p>
 * 输入一个整数，输出该数32位二进制表示中1的个数。其中负数用补码表示。
 * </p>
 *
 * @author goinhn
 * @date 2020-12-09T15:05:27
 */
public class JZ11 {

    /**
     * 通过移动只有一个位数为1的数字来和目标数进行且运算，若为1则目标位置上的数字为1，反之则为0
     *
     * @param n
     * @return
     */
    public int numberOf1(int n) {
        int flag = 1;
        int count = 0;

        while (flag != 0) {
            if ((n & flag) != 0) {
                count++;
            }
            flag = flag << 1;
        }

        return count;
    }

    /**
     * 跟自己自身来进行比较，科循环的位数就是1的个数
     *
     * @param n
     * @return
     */
    public int numberOfOfficial(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = (n - 1) & n;
        }

        return count;
    }


}
