package com.goinhn.interview._2020._20201011_58tongcheng;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 58同城笔试
 *
 * 一个数组中有两个不同的字母，最少交换字母的顺序多少次使得两种字母被划分自一边
 * </p>
 *
 * @author goinhn
 * @date 2020-10-11T20:53:07
 */
public class Main_1 {

    public int lineup(String peoples) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < peoples.length(); i++) {
            int count = map.getOrDefault(peoples.charAt(i), 0) + 1;
            map.put(peoples.charAt(i), count);
        }

        int g = map.get('G');
        int b = map.get('B');

        return Math.min(getMin(peoples, g, 'G'), getMin(peoples, b, 'B'));
    }

    public int getMin(String peoples, int num, char now) {
        int preTime = 0;
        int k = peoples.length() - num;
        for (int i = 0; i < k; i++) {
            if (peoples.charAt(i) == now) {
                preTime += (k - i - 1);
            }
        }

        for (int i = k; i < peoples.length(); i++) {
            if (peoples.charAt(i) != now) {
                preTime += (i - k + 1);
            }
        }

        int aftTime = 0;
        k = num;
        for (int i = k; i < peoples.length(); i++) {
            if (peoples.charAt(i) == now) {
                aftTime += (i - k);
            }
        }

        for (int i = 0; i < k; i++) {
            if (peoples.charAt(i) != now) {
                aftTime += (k - i);
            }
        }

        return Math.min(preTime, aftTime);
    }

    public static void main(String[] args) {
        System.out.println(new Main_1().lineup("GGBBG"));
    }
}
