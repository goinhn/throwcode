package com.goinhn.sworddirectoffer;

/**
 * <p>
 * 机器人的运动范围
 * <p>
 * 地上有一个m行和n列的方格。
 * 一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。
 * 请问该机器人能够达到多少个格子？
 * </p>
 *
 * @author goinhn
 * @date 2020-12-14T16:53:20
 */
public class JZ66 {

    public static void main(String[] args) {
        System.out.println(new JZ66().movingCount(5, 10, 10));
    }

    public int movingCount(int threshold, int rows, int cols) {
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (getPerCount(i) + getPerCount(j) <= threshold) {
                    count++;
                } else {
                    break;
                }
            }
        }

        return count;
    }

    /**
     * 获取数字的各个位数之和
     *
     * @param num
     * @return
     */
    public int getPerCount(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }

        return sum;
    }

}
