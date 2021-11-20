package com.goinhn.sworddirectoffer;

/**
 * <p>
 * 数值的整数次方
 * <p>
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * <p>
 * 这道题算是比较麻烦和难一点的一个了。我这里采用的是二分幂思想，当然也可以采用快速幂。
 * 根据剑指offer书中细节，该题的解题思路如下：
 * 1.当底数为0且指数<0时，会出现对0求倒数的情况，需进行错误处理，设置一个全局变量；
 * 2.判断底数是否等于0，由于base为double型，所以不能直接用==判断
 * 3.优化求幂函数（二分幂）。 当n为偶数，a^n =（a^n/2）*（a^n/2）； 当n为奇数，a^n = a^[(n-1)/2] * a^[(n-1)/2] * a。
 *
 * </p>
 *
 * @author goinhn
 * @date 2020-12-04T18:50:09
 */
public class JZ12 {

    public static double power(double base, int exponent) throws IllegalArgumentException {
//        如果底数为0，且指数为负数，则抛出异常
        if (isEquals(base, 0.0) && exponent < 0) {
            throw new IllegalArgumentException();
        }
//        获取之指数的正负
        int flag = exponent < 0 ? -1 : 1;

//        统一转换为正数进行指数运算
        double result = getPower(base, flag * exponent);

//        最后将正负计入结果
        return flag < 0 ? 1.0 / result : result;
    }

    /**
     * 浮点数判断是否为0
     *
     * @param l
     * @param r
     * @return
     */
    public static boolean isEquals(double l, double r) {
        if (l - r > -0.0000001 && l - r < 0.0000001) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 指数计算部分
     *
     * @param base
     * @param exponent
     * @return
     */
    public static double getPower(double base, int exponent) {
        if (exponent == 0) {
            return 1.0;
        }

        if (exponent == 1) {
            return base;
        }

//        保存一半指数计算的部分，防止重复计算
        double result = getPower(base, exponent >> 1);
        result *= result;
//        如果是奇数则需要多乘一个底数
        if ((exponent & 1) == 1) {
            result *= base;
        }

        return result;
    }


}
