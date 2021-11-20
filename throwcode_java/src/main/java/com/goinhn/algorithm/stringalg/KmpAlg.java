package com.goinhn.algorithm.stringalg;

/**
 * <p>
 * KMP算法
 * <p>
 * 它是用来解决字符串查找的问题，可以在一个字符串（S）中查找一个子串（W）出现的位置。
 * KMP 算法把字符匹配的时间复杂度缩小到 O(m+n) ,而空间复杂度也只有O(m)。
 * 因为“暴力搜索”的方法会反复回溯主串，导致效率低下，
 * 而KMP算法可以利用已经部分匹配这个有效信息，保持主串上的指针不回溯，通过修改子串的指针，让模式串尽量地移动到有效的位置。
 * <p>
 * 流程
 * <p>
 * 将子串在公共字符串中进行搜索，在每次搜索的过程中计算匹配的部分的部分匹配值，得到下一次的向下移动的距离，充分利用已经匹配的信息
 * 部分匹配值计算（Partial Match Table)
 * 前缀：除了最后一个字符以外，一个字符串的全部头集合组合
 * 后缀：除了第一个字符以外，一个字符串的全部尾集合组合
 * 部分匹配值就是前缀集合和后缀集合的交集中最长元素的长度
 * <p>
 * 复杂度
 * 公共字符串的长度n
 * 子串的长度m
 * 时间复杂度：O(m + n)
 * 空间复杂度：O(m)
 * </p>
 *
 * @author goinhn
 * @date 2020-12-02T08:46:17
 */
public class KmpAlg {

    public static void main(String[] args) {
        String str = "BBC ABCDAB ABCDABCDABDE";
        String subStr = "ABCDABD";

        System.out.println(KmpOfficial.getPublicString(str, subStr));
    }

    /**
     * 暴力法进行循环匹配
     */
    public static class ViolenceLoop {
        public static int getPublicString(String str, String subStr) {
//            判断目标字符串的规则是否符合存在公共部分的可能
            if (str == null ||
                    subStr == null ||
                    str.length() == 0 ||
                    subStr.length() == 0 ||
                    str.length() < subStr.length()) {
                return -1;
            }

            int i = 0, j = 0;
//            暴力法定义两个指针进行循环匹配
            while (i < str.length() && j < subStr.length()) {
                if (str.charAt(i) == subStr.charAt(j)) {
                    i++;
                    j++;
//                    匹配失败则回溯两个指针，公共字串的指针跳向下一个位置
                } else {
                    i = i - j + 1;
                    j = 0;
                }
            }

            if (j == subStr.length()) {
                return i - j;
            } else {
                return -1;
            }
        }
    }

    /**
     * 自己手动实现的KMP算法
     */
    public static class MyTry {
        public static int getPublicString(String str, String subStr) {
//            判断目标字符串的规则是否符合存在公共部分的可能
            if (str == null ||
                    subStr == null ||
                    str.length() == 0 ||
                    subStr.length() == 0 ||
                    str.length() < subStr.length()) {
                return -1;
            }

//            定义公共字符串的指针
            int index = 0;
//            当公共部分的指针跑到剩下的距离小于匹配字符串的长度的时候，没有公共部分的可能，停止循环
            while (index <= str.length() - subStr.length()) {
                int i;
                for (i = 0; i < subStr.length(); i++) {
                    if (subStr.charAt(i) != str.charAt(index + i)) {
                        break;
                    }
                }

                if (i == subStr.length()) {
                    return index;
                } else {
                    int move = getMoveLocation(str, index, index + i);
                    index += move;
                }
            }

            return -1;
        }

        public static int getMoveLocation(String str, int left, int right) {
            int gap = 1;
            while (gap < right - left) {
                if (str.substring(left + gap, right).equals(str.substring(left, right - gap))) {
                    return gap;
                }
                gap++;
            }

            return gap;
        }

    }


    /**
     * kmp算法较好的实现
     */
    public static class KmpOfficial {
        public static int getPublicString(String str, String subStr) {
//            计算条件判断
            if (str == null ||
                    subStr == null ||
                    str.length() == 0 ||
                    subStr.length() == 0 ||
                    str.length() < subStr.length()) {
                return -1;
            }

//            获取pmt数组，将结果存储在数组中，在这里需要额外的空间m
            int[] pmt = getPmt(subStr);
//            定义公共串的指针和子串的指针
            int i = 0, j = 0;
            while (i < str.length() && j < subStr.length()) {
//                字符匹配则双指针向后移动
                if (str.charAt(i) == subStr.charAt(j)) {
                    i++;
                    j++;
//                    如果第一个字符就不匹配的话，移动公共串的指针
                } else if (j == 0) {
                    i++;
                } else {
//                    否则移动指定的pmt表上指定的位数
                    j = pmt[j - 1];
                }
            }

            if (j == subStr.length()) {
                return i - j;
            } else {
                return -1;
            }
        }

        /**
         * 计算pmt表
         *
         * @param str
         * @return
         */
        public static int[] getPmt(String str) {
            int[] pmt = new int[str.length()];
//            第一个位置一定是0
            pmt[0] = 0;
            int i = 1, j = 0;
            while (i < str.length()) {
//                相等则填入位移的值
                if (str.charAt(i) == str.charAt(j)) {
                    pmt[i] = j + 1;
                    i++;
//                    不同则设置为0
                } else {
                    pmt[i] = 0;
                    j = 0;
                }
                i++;
            }

            return pmt;
        }
    }

}
