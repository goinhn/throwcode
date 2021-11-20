package com.goinhn.interview._2020._20201019_xinhuasan;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 新华三
 *
 * 计算数组中构成的大于100的三位数中最大值和最小值的差值
 * </p>
 *
 * @author goinhn
 * @date 2020-10-19T23:54:51
 */
public class Main_1 {

    public int sub(String input) {
        if (input == null || input.length() == 0) {
            return -1;
        }

        String[] now = input.split(" ");
        int[] num = new int[now.length];
        for (int i = 0; i < now.length; i++) {
            if (Character.isDigit(now[i].charAt(0))) {
                num[i] = Integer.parseInt(now[i]);
            } else {
                return -1;
            }

        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < num.length; j++) {
                if (j == i) {
                    continue;
                }
                for (int n = 0; n < num.length; n++) {
                    if (n == i || n == j) {
                        continue;
                    }
                    int tempNum = num[i] * 100 + num[j] * 10 + num[n];
                    if (tempNum >= 100) {
                        list.add(tempNum);
                    }
                }
            }
        }

        int max = -1;
        int min = 1000;
        for (Integer integer : list) {
            max = Math.max(max, integer);
            min = Math.min(min, integer);
        }

        if (max == -1 || min == 1000) {
            return -1;
        } else {
            return max - min;
        }
    }

}
