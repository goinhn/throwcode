package com.goinhn.algorithm.pruning;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * <p>
 * leetcode 51
 * leetcode 52
 * <p>
 * N 皇后
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * <p>
 * 给定一个整数 n，返回所有不同的n皇后问题的解决方案。
 * <p>
 * 每一种解法包含一个明确的n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * <p>
 * 示例：
 * 输入：4
 * 输出：[
 * [".Q..",  // 解法 1
 * "...Q",
 * "Q...",
 * "..Q."],
 * <p>
 * ["..Q.",  // 解法 2
 * "Q...",
 * "...Q",
 * ".Q.."]
 * ]
 * 解释: 4 皇后问题存在两个不同的解法。
 * <p>
 * 提示：
 * 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。
 * <p>
 * time:O(n^2)
 * space:O(n)
 * </p>
 *
 * @author goinhn
 * @date 2021-01-02T13:09:52
 */
public class NQueens {

    /**
     * 最后棋盘的结果
     */
    private List<List<String>> result = new LinkedList<>();

    /**
     * 列中被占据的位置
     */
    private Set<Integer> cols = new HashSet<>();

    /**
     * 撇中被占据的位置
     */
    private Set<Integer> pies = new HashSet<>();

    /**
     * 捺中被占据的位置
     */
    private Set<Integer> nas = new HashSet<>();


    /**
     * 使用剪枝的方式
     *
     * @param n
     * @return
     */
    public List<List<String>> solveNQueens(int n) {
        if (n < 1) {
            return result;
        }

        dfsHelper(n, 0, new LinkedList<>());

        return result;
    }

    /**
     * 剪枝递归函数
     *
     * @param n
     * @param row
     * @param curStat
     */
    public void dfsHelper(int n, int row, List<String> curStat) {
        if (row > n - 1) {
            List<String> now = new LinkedList<>(curStat);
            result.add(now);
            return;
        }

        String line = "";
        for (int col = 0; col < n; col++) {
            if (cols.contains(col) || pies.contains(row + col) || nas.contains(row - col)) {
                line += ".";
                continue;
            }

//            保存原本的字符形式
            String temp = line;
            cols.add(col);
            pies.add(row + col);
            nas.add(row - col);
            line += "Q";
            for (int i = col + 1; i < n; i++) {
                line += ".";
            }
            curStat.add(line);

            dfsHelper(n, row + 1, curStat);

//            开始回溯恢复原有的字符
            curStat.remove(curStat.size() - 1);
            line = temp + ".";
            cols.remove(col);
            pies.remove(row + col);
            nas.remove(row - col);
        }

    }

}
