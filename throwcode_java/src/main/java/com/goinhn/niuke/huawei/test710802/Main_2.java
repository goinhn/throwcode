package com.goinhn.niuke.huawei.test710802;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * https://www.nowcoder.com/test/question/analytic?tid=32588204
 * 华为2016研发工程师编程题
 */
public class Main_2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            char[] c = in.next().toCharArray();
            StringBuffer sb = new StringBuffer();
            Set<Character> set = new HashSet<Character>();
            for (int i = 0; i < c.length; i++) {
                if (set.add(c[i])) {
                    sb.append(c[i]);
                }
                System.out.println(sb.toString());
            }
        }
    }

}
