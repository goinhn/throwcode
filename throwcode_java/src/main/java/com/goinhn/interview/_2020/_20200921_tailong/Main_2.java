package com.goinhn.interview._2020._20200921_tailong;

/**
 * <p>
 * 汉诺塔问题
 * </p>
 *
 * @author goinhn
 * @date 2020-09-22T00:25:51
 */
public class Main_2 {

    public static void main(String[] args) {
        hanoi(0, "A", "B", "C");
    }

    /**
     * @param num
     * @param from
     * @param to
     * @param helper
     */
    public static void hanoi(int num, String from, String helper, String to) {
        if (num < 1) {
            return;
        }

        if (num == 1) {
            move(from, to);
            return;
        }

        hanoi(num - 1, from, to, helper);
        move(from, to);
        hanoi(num - 1, helper, from, to);
    }

    /**
     * 打印解法
     *
     * @param from
     * @param to
     */
    public static void move(String from, String to) {
        System.out.println(from + "-->" + to);
    }

}
