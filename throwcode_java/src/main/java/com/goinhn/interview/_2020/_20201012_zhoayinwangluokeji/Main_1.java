package com.goinhn.interview._2020._20201012_zhoayinwangluokeji;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * <p>
 * 招银网络科技面试
 * <p>
 * 假设一个字符串由小写字母构成，输出字符串中出现次数最多的字符，如果存在相同最大次数的字符，输出最小的字符
 * </p>
 *
 * @author goinhn
 * @date 2020-10-13T01:27:19
 */
public class Main_1 {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int count = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < count; i++) {
            String str = scanner.nextLine();
            System.out.println(getMaxChar(str));
        }

        scanner.close();
    }

    public static char getMaxChar(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            int count = map.getOrDefault(str.charAt(i), 0) + 1;
            map.put(str.charAt(i), count);
        }

        int max = 0;
        Set<Character> set = map.keySet();
        for (Character character : set) {
            max = Math.max(max, map.get(character));
        }

        char now = 123;
        for (Character character : set) {
            if (max == map.get(character) && now > character) {
                now = character;
            }
        }

        return now;
    }
}