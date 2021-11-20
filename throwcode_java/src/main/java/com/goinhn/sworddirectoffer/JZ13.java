package com.goinhn.sworddirectoffer;

/**
 * <p>
 * 调整数组的顺序使奇数位于偶数前面
 * <p>
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * </p>
 *
 * @author goinhn
 * @date 2020-12-04T23:44:02
 */
public class JZ13 {

    /**
     * 找出奇数的个数，将区分的后的数组放入新的数组
     *
     * @param array
     */
    public void reOrderArray(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }

        int oddCount = 0;
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & 1) == 1) {
                oddCount++;
            }
        }

        int oddBegin = 0;
        int[] newArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & 1) == 1) {
//                奇数的指针位置放入数字
                newArray[oddBegin++] = array[i];
            } else {
//                偶数指针的位置放入数字
                newArray[oddCount++] = array[i];
            }
        }

        System.arraycopy(newArray, 0, array, 0, array.length);
    }

    /**
     * 直接在原有的数组上进行移动，保持位置不变的原则为偶数或者奇数按照顺序进行移动，相邻的偶数和奇数才能进行数字的交换
     *
     * @param array
     */
    public void reOrderArrayOfficial(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }

        for (int i = 0; i < array.length; i++) {
//            找到第一个出现的奇数
            if (isEven(array[i])) {
                int j = i + 1;
                while (j < array.length && isEven(array[j])) {
                    j++;
                }
                if (j < array.length) {
                    int temp = array[j];
                    System.arraycopy(array, i, array, i + 1, j - i);
                    array[i] = temp;
                }
            }
        }
    }

    /**
     * 判断是否是偶数
     *
     * @param number
     * @return
     */
    public boolean isEven(int number) {
        return number % 2 == 0;
    }
}
