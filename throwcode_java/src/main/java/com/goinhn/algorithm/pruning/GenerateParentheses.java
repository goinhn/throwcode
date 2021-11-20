package com.goinhn.algorithm.pruning;

import java.util.LinkedList;
import java.util.List;

/**
 * <p>
 * leetcode 22
 * <p>
 * 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 * 示例：
 * 输入：n = 3
 * 输出：[
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 * </p>
 *
 * @author goinhn
 * @date 2021-01-02T11:29:54
 */
public class GenerateParentheses {

    private List<String> result = new LinkedList<>();

    public List<String> generateParenthesis(int n) {
        if (n < 1) {
            return result;
        }

        generateParenthesisHelper("", n, n);
        return result;
    }

    public void generateParenthesisHelper(String str, int left, int right) {
        if (left == 0 && right == 0) {
            result.add(str);
            return;
        }

        if (left > 0) {
            generateParenthesisHelper(str + "(", left - 1, right);
        }

        if (left < right) {
            generateParenthesisHelper(str + ")", left, right - 1);
        }
    }

}
