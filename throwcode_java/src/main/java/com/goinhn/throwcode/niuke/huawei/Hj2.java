package com.goinhn.throwcode.niuke.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 2.计算某字符出现次数
 *
 * @author goinhn
 * @date 2022/7/18
 */
public class Hj2 {

    /**
     * time:(1)
     * space:(1)
     */
    private static class Solution1 {

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str = br.readLine();
            String charStr = br.readLine();
            System.out.println(getCount(str, charStr));
        }

        private static int getCount(String str, String charStr) {
            if (str == null || str.length() == 0 || charStr == null || charStr.length() == 0) {
                return 0;
            }

            str = str.toLowerCase();
            charStr = charStr.toLowerCase();
            char singleChar = charStr.charAt(0);
            int count = 0;
            for (Character c : str.toCharArray()) {
                if (c.equals(singleChar)) {
                    count++;
                }
            }

            return count;
        }
    }

}
