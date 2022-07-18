package com.goinhn.throwcode.niuke.huawei;

import java.util.Scanner;

/**
 * 1.字符串最后一个单词的长度
 *
 * @author goinhn
 * @date 2022/7/18
 */
public class Hj1 {

    /**
     * time:O(1)
     * space:O(1)
     */
    private static class Solution1 {
        public static class Main {
            public static void main(String[] args) throws Exception {
                Scanner scanner = new Scanner(System.in);
                String str = scanner.nextLine();
                System.out.println(getLen(str));
            }

            private static int getLen(String str) {
                if (str == null || str.length() == 0) {
                    return 0;
                }

                int i = str.length() - 1;
                int count = 0;
                while (i > -1 && str.charAt(i) != ' ') {
                    count++;
                    i--;
                }

                return count;
            }
        }
    }
}
