package com.goinhn.thorwcode.leetcode.question._1301_1400;

import java.util.ArrayList;
import java.util.List;

/**
 * @author goinhn
 * @date 2024/4/23
 */
public class Sol1319 {

    private static class Solution1 {
        public int makeConnected(int n, int[][] connections) {
            if (connections.length < n - 1) {
                return -1;
            }

            List<Integer>[] edges = new List[n];
            for (int i = 0; i < n; i++) {
                edges[i] = new ArrayList<>();
            }
            for (int[] connection : connections) {
                edges[connection[0]].add(connection[1]);
                edges[connection[1]].add(connection[0]);
            }

            boolean[] visited = new boolean[n];
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    continue;
                }
                dfs(edges, visited, i);
                count++;
            }

            return count - 1;
        }

        public void dfs(List<Integer>[] edges, boolean[] visited, int idx) {
            if (visited[idx]) {
                return;
            }
            visited[idx] = true;
            for (int i = 0; i < edges[idx].size(); i++) {
                dfs(edges, visited, edges[idx].get(i));
            }
        }
    }

}
