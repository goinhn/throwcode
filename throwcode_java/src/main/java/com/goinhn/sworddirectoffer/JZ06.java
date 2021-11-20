package com.goinhn.sworddirectoffer;

/**
 * <p>
 * 旋转数组的最小数字
 * <p>
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * </p>
 *
 * @author goinhn
 * @date 2020-12-08T14:32:09
 */
public class JZ06 {

    /**
     * 顺序遍历进行查找
     *
     * @param array
     * @return
     */
    public int minNumberInRotateArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return array[i + 1];
            }
        }

        return array[array.length - 1];
    }

    /**
     * 二分法，左指针指向左边的值，右指针指向右边的值，每次计算中间的值来移动左右指针，最后左右指针相邻返回右边的指针指向的值即可
     *
     * @param array
     * @return
     */
    public int minNumberInRotateArrayOfficial(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }

        int left = 0;
        int right = array.length - 1;

        while (left < right - 1) {
            int middle = (left + right) / 2;
            int middleNum = array[middle];
            if (middleNum >= array[left]) {
                left = middle;
            } else if (middleNum <= array[right]) {
                right = middle;
            }
        }

        return array[right];
    }

}
