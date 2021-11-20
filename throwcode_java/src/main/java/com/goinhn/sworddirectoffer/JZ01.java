package com.goinhn.sworddirectoffer;

/**
 * <p>
 * 二维数组中的查找
 * <p>
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * <p>
 * complexity
 * time: O(m + n)
 * space: o(1)
 * </p>
 *
 * @author goinhn
 * @date 2020-12-05T14:24:12
 */
public class JZ01 {

    public static boolean find(int[][] arr, int target) {
        if (arr == null || arr.length == 0) {
            return false;
        }

        int x = 0;
        int y = arr[0].length - 1;

        while (x < arr.length && y > -1) {
            if (arr[x][y] < target) {
                x++;
            } else if (arr[x][y] > target) {
                y--;
            } else {
                return true;
            }
        }

        return false;
    }

}
