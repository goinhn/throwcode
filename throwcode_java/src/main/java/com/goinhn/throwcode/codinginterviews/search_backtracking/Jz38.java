package com.goinhn.throwcode.codinginterviews.search_backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 38.字符串的排列
 *
 * @author goinhn
 * @date 2022/6/14
 */
public class Jz38 {

    /**
     * 深度优先遍历 + 剪枝
     * <p>
     * time:O(n!n)
     * space:O(n^2)
     */
    private static class Solution1 {

        private char[] c;

        private List<String> res;

        public String[] permutation(String s) {
            if (s == null || s.length() == 0) {
                return new String[0];
            }

            c = s.toCharArray();
            res = new ArrayList<>();

            innerDfs(0);

            return res.toArray(new String[0]);
        }

        private void innerDfs(int index) {
            // 如果长度刚好为最后一个，则完成一次全排列，加入结果
            if (index == c.length - 1) {
                res.add(String.valueOf(c));
                return;
            }

            // 通过set来剪枝，存在相同的字母则跳过排列
            Set<Character> set = new HashSet<>();
            for (int i = index; i < c.length; i++) {
                if (set.contains(c[i])) {
                    continue;
                }
                set.add(c[i]);
                // 直接将后面待排列的字母进行交换构成新的排列字符串，无需拷贝构造新的字符串
                swap(index, i);
                innerDfs(index + 1);
                // 上述字符串完成排列后，交换回去，防止影响后续排列
                swap(i, index);
            }

        }

        private void swap(int x, int y) {
            char temp = c[x];
            c[x] = c[y];
            c[y] = temp;
        }

    }

}
