package com.goinhn.interview._2020._20201018_qianxin;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * 计算200以内的阶乘
 * 通过数组的形式来进行存储数字
 */
public class Main_2 {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int num = scanner.nextInt();
        if (num < 1 || num > 200) {
            System.out.println("Error");
        } else {
            System.out.println(getNum(num));
        }
        scanner.close();
    }

    public static String getNum(int num) {
        // 使用链表来存放数字
        List<Integer> list = new LinkedList<>();
        list.add(1);
        for (int i = 2; i <= num; i++) {
            int size = list.size();
            // 对每个位上的数进行运算，并将新的结果替换到list中去，计算的顺序是从最高位开始
            for (int j = size - 1; j > -1; j--) {
                int now = list.get(j) * i;
                list.set(j, now % 10);
                now /= 10;
                int index = j + 1;
                while (now > 0) {
                    // 未超出list的部分，直接替换原list上的值
                    if (index < list.size()) {
                        now += list.get(index);
                        list.set(index, now % 10);
                        // 超出list的部分，作为最高位的元素添加在链表的最后
                    } else {
                        list.add(now % 10);
                    }
                    index++;
                    now /= 10;
                }
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = list.size() - 1; i > -1; i--) {
            stringBuilder.append(list.get(i));
        }

        return stringBuilder.toString();
    }

}