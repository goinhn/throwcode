package com.goinhn.algorithm.stringalg;

import java.util.Scanner;

/**
 * <p>
 * 括号匹配深度
 * <p>
 * 爱奇艺 2018 秋招 Java： 一个合法的括号匹配序列有以下定义:
 * <p>
 * 空串""是一个合法的括号匹配序列
 * 如果"X"和"Y"都是合法的括号匹配序列,"XY"也是一个合法的括号匹配序列
 * 如果"X"是一个合法的括号匹配序列,那么"(X)"也是一个合法的括号匹配序列
 * 每个合法的括号序列都可以由以上规则生成。
 * 例如: "","()","()()","((()))"都是合法的括号序列 对于一个合法的括号序列我们又有以下定义它的深度:
 * <p>
 * 空串""的深度是0
 * 如果字符串"X"的深度是x,字符串"Y"的深度是y,那么字符串"XY"的深度为max(x,y)
 * 如果"X"的深度是x,那么字符串"(X)"的深度是x+1
 * 例如: "()()()"的深度是1,"((()))"的深度是3。牛牛现在给你一个合法的括号序列,需要你计算出其深度。
 * <p>
 * 输入描述:
 * 输入包括一个合法的括号序列s,s长度length(2 ≤ length ≤ 50),序列中只包含'('和')'。
 * <p>
 * 输出描述:
 * 输出一个正整数,即这个序列的深度。
 * </p>
 *
 * @author goinhn
 * @date 2020-12-03T16:18:17
 */
public class BracketsDeep {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int count = 0, max = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                count++;
            } else {
                count--;
            }
            max = Math.max(max, count);
        }
        System.out.println(max);
        scanner.close();
    }

}
