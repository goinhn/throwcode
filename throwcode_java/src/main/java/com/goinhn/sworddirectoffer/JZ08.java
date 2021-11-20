package com.goinhn.sworddirectoffer;

/**
 * <p>
 * 跳台阶
 * <p>
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * <p>
 * a.如果两种跳法，1阶或者2阶，那么假定第一次跳的是一阶，那么剩下的是n-1个台阶，跳法是f(n-1);
 * b.假定第一次跳的是2阶，那么剩下的是n-2个台阶，跳法是f(n-2)
 * c.由a，b假设可以得出总跳法为: f(n) = f(n-1) + f(n-2)
 * d.然后通过实际的情况可以得出：只有一阶的时候 f(1) = 1 ,只有两阶的时候可以有 f(2) = 2 找规律分析法： f(1) = 1, f(2) = 2, f(3) = 3, f(4) = 5，
 * 可以总结出f(n) = f(n-1) + f(n-2)的规律。
 * 但是为什么会出现这样的规律呢？假设现在6个台阶，我们可以从第5跳一步到6，这样的话有多少种方案跳到5就有多少种方案跳到6，
 * 另外我们也可以从4跳两步跳到6，跳到4有多少种方案的话，就有多少种方案跳到6，其他的不能从3跳到6什么的啦，所以最后就是f(6) = f(5) + f(4)；
 * </p>
 *
 * @author goinhn
 * @date 2020-12-04T14:06:17
 */
public class JZ08 {

    public int jumpFloor(int n) {
        if (n < 1) {
            return 0;
        }

        if (n < 3) {
            return n;
        }

        return jumpFloor(n - 1) + jumpFloor(n - 2);
    }

    public int jumpFloorOfficial(int n) {
        if (n < 1) {
            return 0;
        }

        if (n < 3) {
            return n;
        }

        int first = 1, second = 2, third = 3;
        for (int i = 3; i < n + 1; i++) {
            third = first + second;
            first = second;
            second = third;
        }

        return third;
    }


}
