package com.goinhn.thorwcode.leetcode.question._501_600;

/**
 * 547.省份数量
 *
 * @author goinhn
 * @date 2024/4/6
 */
public class Sol547 {

    public static class Solution1 {
        public int findCircleNum(int[][] isConnected) {
            boolean[] visited = new boolean[isConnected.length];
            int count = 0;
            for (int i = 0; i < isConnected.length; i++) {
                if (visited[i]) {
                    continue;
                }
                dfs(isConnected, visited, i);
                count++;
            }

            return count;
        }

        private void dfs(int[][] isConnected, boolean[] visited, int x) {
            for (int j = 0; j < isConnected[x].length; j++) {
                if (isConnected[x][j] == 1 && !visited[j]) {
                    visited[j] = true;
                    dfs(isConnected, visited, j);
                }
            }
        }
    }
}
