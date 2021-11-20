package com.goinhn.interview._2020._20200920_duxiaoman;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 涂色
 * 小A正在学画画，现在画稿已经画好了，只下涂色部分了。但是小A发现，他的颜料不够了。
 * 每一块颜料能涂一个色块，每一个色块的颜色是事先决定好了的。
 * 由于颜料不够，小A只能尽其所能来涂色。如果一个色块没有了颜料，就不能涂色。
 * 现在，给你画中需要的色块颜色，和小A现在手上有的颜料，请你计篡小A能涂多少个色块。
 * <p>
 * 输入描述
 * 输入包含两个字符串，都仅包大写字母，每一种字母代表一种颜色。
 * 第一个字符串S代表小A手上的颜料，第二个字符串T代表画需要的颜料。
 * 1<=|S|,|T|<=1000
 * 输出描述
 * 输出包含一数，即最多能涂多少个色块。
 * <p>
 * 输入：
 * AAB
 * ABC
 * <p>
 * 输出：
 * 2
 */
public class Main_1 {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        char[] color = scanner.nextLine().toCharArray();
        char[] square = scanner.nextLine().toCharArray();

        System.out.println(getNum(color, square));
        scanner.close();
    }

    /**
     * 使用map进行遍历即可
     *
     * @param color
     * @param square
     * @return
     */
    public static int getNum(char[] color, char[] square) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : color) {
            int count = map.getOrDefault(c, 0) + 1;
            map.put(c, count);
        }

        int count = 0;
        for (int i = 0; i < square.length; i++) {
            if (map.containsKey(square[i])) {
                int now = map.get(square[i]);
                if (now > 0) {
                    count++;
                    now--;
                    map.put(square[i], now);
                }
            }
        }

        return count;
    }

}