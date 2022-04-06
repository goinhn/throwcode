package com.goinhn.throwcode.codinginterviews.search_backtracking;

/**
 * 12.矩阵中的路径
 *
 * @author goinhn
 * @date 2022/4/6
 */
public class Jz12 {

    private static class Solution1 {
        public boolean exist(char[][] board, String word) {
            char[] words = word.toCharArray();
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (existHelper(board, words, i, j, 0)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean existHelper(char[][] board, char[] words, int i, int j, int k) {
            if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != words[k]) {
                return false;
            }

            if (k == words.length - 1) {
                return true;
            }

            board[i][j] = '\0';
            boolean res = existHelper(board, words, i + 1, j, k + 1)
                    || existHelper(board, words, i - 1, j, k + 1)
                    || existHelper(board, words, i, j - 1, k + 1)
                    || existHelper(board, words, i, j + 1, k + 1);
            board[i][j] = words[k];
            return res;
        }
    }
}
