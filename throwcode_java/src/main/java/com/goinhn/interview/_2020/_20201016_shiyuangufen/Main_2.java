package com.goinhn.interview._2020._20201016_shiyuangufen;

/**
 * <p>
 * 一个数组，数组上的数字表示人物还能上升几个阶梯，计算一个数组从头开始能否到达末尾
 * </p>
 *
 * @author goinhn
 * @date 2020-10-16T22:41:18
 */
public class Main_2 {

    public boolean isArrived(int[] arr) {
        int index = 0;
        while (index < arr.length - 1) {
            int step = arr[index];
            if (step == 0) {
                return false;
            }
            index += step;
        }

        return true;
    }

}
