package com.goinhn.interview._2020._20200921_wuduan;

/**
 * <p>
 * 无端科技
 * <p>
 * 题目描述
 * 给出一个字符串t，仅包含'S'和'K'字符且'S'和'K'字符数量相等。编写函数intstringSplit(Stringt)将该字符串分成尽可能多的子字符串
 * 符串中'S'和'K'字符数量相等，函数返回值为切分的子字符串的最大数量
 * 示例1
 * 输入：t="SKSSKKSKSK'
 * 输出：4
 * 解释：t可以分割为"SK"，"SSKK""SK""SK"，母个子字符串中都包含相同数量的'S'和'K'。
 * 示例2．
 * 输入：t="SKKKKSSSKS"
 * 输出．3
 * 解释：t可以分割为"SK"，"KKKSSS""KS"母个子字符串中都包含相同数量的'S'和'K'。
 * 示例3．
 * 输入：t="SSSSKKKK，
 * 输出：1
 * 解释：t只能保持原样"SSSSKKKK"
 * 且保证母一个子字
 * 一个字符串中有相同数量的
 * <p>
 * 时间复杂度:O(n)
 * 空间复杂度:O(1)
 * </p>
 *
 * @author goinhn
 * @date 2020-09-21T23:17:00
 */
public class Main_1 {

    public static void main(String[] args) {
        System.out.println(stringSplit("SSSSKKKK"));
    }

    /**
     * 使用两个count记录s和k出现的次数，从头开始遍历，当s和k记录的数相同且不为0的时候就可以做一次分割
     *
     * @param t
     * @return
     */
    public static int stringSplit(String t) {
        char[] now = t.toCharArray();
        int sCount = 0;
        int kCount = 0;
        int count = 0;
        for (int i = 0; i < now.length; i++) {
            if (now[i] == 'S') {
                sCount++;
            } else if (now[i] == 'K') {
                kCount++;
            }

            if (sCount == kCount && sCount != 0) {
                count++;
                sCount = 0;
                kCount = 0;
            }
        }

        return count;
    }
}
