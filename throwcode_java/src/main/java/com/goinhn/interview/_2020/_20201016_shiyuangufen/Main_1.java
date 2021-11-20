package com.goinhn.interview._2020._20201016_shiyuangufen;

/**
 * <p>
 * 视源股份笔试题
 * 一个数组，确定某个元素后最近的比他大的元素的距离，没有的话就标记为0
 * </p>
 *
 * @author goinhn
 * @date 2020-10-16T22:54:32
 */
public class Main_1 {

    public int[] getVisitorCounts(int[] arr) {
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int index = i;
            int count = 0;
            while (index + 1 < arr.length && arr[index + 1] < arr[i]) {
                count++;
                index++;
            }
            result[i] = count;
        }

        return result;
    }

}
