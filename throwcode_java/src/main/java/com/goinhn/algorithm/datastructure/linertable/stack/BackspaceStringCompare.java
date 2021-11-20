package com.goinhn.algorithm.datastructure.linertable.stack;

import java.util.Stack;

/**
 * <p>
 * leetcode 844
 * <p>
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 * 注意：如果对空文本输入退格字符，文本继续为空。
 * <p>
 * 示例 1：
 * 输入：S = "ab#c", T = "ad#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “ac”。
 * <p>
 * 示例 2：
 * 输入：S = "ab##", T = "c#d#"
 * 输出：true
 * 解释：S 和 T 都会变成 “”。
 * <p>
 * 示例 3：
 * 输入：S = "a##c", T = "#a#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “c”。
 * <p>
 * 示例 4：
 * 输入：S = "a#c", T = "b"
 * 输出：false
 * 解释：S 会变成 “c”，但 T 仍然是 “b”。
 * <p>
 * 提示：
 * 1 <= S.length <= 200
 * 1 <= T.length <= 200
 * S 和 T 只含有小写字母以及字符 '#'。
 * <p>
 * 进阶：
 * 你可以用 O(N) 的时间复杂度和 O(1) 的空间复杂度解决该问题吗？
 * <p>
 * 时间复杂度:O(M+N)
 * 空间复杂度:O(M+N)
 * </p>
 *
 * @author goinhn
 * @date 2020-09-12T20:09:48
 */
public class BackspaceStringCompare {

    public boolean backspaceCompare(String S, String T) {
        S = build(S);
        T = build(T);

        return S.equals(T);
    }

    /**
     * 利用栈返回清除退格键后的字符串
     *
     * @param str
     * @return
     */
    public String build(String str) {
        Stack stack = new Stack();
        for (char c : str.toCharArray()) {
            if (c != '#') {
                stack.push(c);
            } else if (!stack.isEmpty()) {
                stack.pop();
            }
        }

        return String.valueOf(stack);
    }


    /**
     * 利用双指针从右往左进行判断，遇到多少的退格符号就跳过多少的
     *
     * @param S
     * @param T
     * @return
     */
    public boolean backspaceComparePointer(String S, String T) {
        int i = S.length() - 1;
        int j = T.length() - 1;
        int backspace = 0;

        while (i >= 0 || j >= 0) {
            // 根据退格的个数来进行退格
            while (i >= 0) {
                if (S.charAt(i) == '#') {
                    backspace++;
                    i--;
                } else if (backspace > 0) {
                    backspace--;
                    i--;
                } else {
                    break;
                }
            }

            while (j >= 0) {
                if (T.charAt(j) == '#') {
                    backspace++;
                    j--;
                } else if (backspace > 0) {
                    backspace--;
                    j--;
                } else {
                    break;
                }
            }

            // 判断没有退给的字符是否相等
            if (i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j)) {
                return false;
            }

            // 如果存在其中一个跑完另一个没有跑完的话就判断失败
            if ((i >= 0) != (j >= 0)) {
                return false;
            }

            i--;
            j--;
        }

        return true;
    }

}
