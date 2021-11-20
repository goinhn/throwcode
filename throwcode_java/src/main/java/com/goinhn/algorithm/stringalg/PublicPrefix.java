package com.goinhn.algorithm.stringalg;

import java.util.Arrays;

/**
 * <p>
 * 字符串的最长公共前缀输出
 * 关键取得最小的字符串和最大的字符串进行比较即可
 * </p>
 *
 * @author goinhn
 * @date 2020-12-02T21:45:46
 */
public class PublicPrefix {

    public static class JavaGuide {
        public static String getPublicPrefix(String[] strS) {
            if (!checkStrS(strS)) {
                return "";
            }
//           对字符数组进行排序，获得字符顺序
            Arrays.sort(strS);

            int m = strS[0].length();
            int n = strS[strS.length - 1].length();
            int min = Math.min(m, n);
            int index = 0;
            while (index < min) {
                if (strS[0].charAt(index) == strS[strS.length - 1].charAt(index)) {
                    index++;
                } else {
                    break;
                }
            }

            return strS[0].substring(0, index);

        }

//        字符数组的合理检查
        public static boolean checkStrS(String[] strS) {
            boolean flag = false;
            if (strS != null) {
                for (int i = 0; i < strS.length; i++) {
                    if (strS[i] != null && strS[i].length() != 0) {
                        flag = true;
                    } else {
                        flag = false;
                        break;
                    }
                }
            }

            return flag;
        }
    }


}
