package com.goinhn.throwcode.codinginterviews.temp;

/**
 * <p>
 * 变态跳台阶问题
 * <p>
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * <p>
 * 假设n>=2，第一步有n种跳法：跳1级、跳2级、到跳n级
 * 跳1级，剩下n-1级，则剩下跳法是f(n-1)
 * 跳2级，剩下n-2级，则剩下跳法是f(n-2)
 * ......
 * 跳n-1级，剩下1级，则剩下跳法是f(1)
 * 跳n级，剩下0级，则剩下跳法是f(0)
 * 所以在n>=2的情况下： f(n)=f(n-1)+f(n-2)+...+f(1)
 * 因为f(n-1)=f(n-2)+f(n-3)+...+f(1) 所以f(n)=2*f(n-1) 又f(1)=1,所以可得f(n)=2^(number-1)
 * </p>
 *
 * @author goinhn
 * @date 2020-12-04T15:22:13
 */
public class JZ09 {

    public int jumpFloor(int n) {
//        移位运算符更快
        return 1 << --n;
    }

}
