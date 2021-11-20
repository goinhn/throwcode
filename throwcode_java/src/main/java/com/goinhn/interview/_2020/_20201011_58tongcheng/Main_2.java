package com.goinhn.interview._2020._20201011_58tongcheng;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 对数组去重，输出新的数组
 * </p>
 *
 * @author goinhn
 * @date 2020-10-11T20:25:53
 */
public class Main_2 {

    public int[] removeDuplicate(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            int count = map.getOrDefault(array[i], 0) + 1;
            map.put(array[i], count);
        }

        int[] arr = new int[map.size()];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            int count = map.getOrDefault(array[i], 0) - 1;
            if (count == 0) {
                arr[index++] = array[i];
            }
            map.put(array[i], count);
        }

        return arr;
    }


}
