package com.goinhn.throwcode.codinginterviews.search_backtracking;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 13.机器人的运动范围
 *
 * @author goinhn
 * @date 2022/5/7
 */
public class Jz13 {

    /**
     * 深度优先搜索
     * <p>
     * time:O(mn)
     * space:O(mn)
     */
    private static class Solution1 {

        private int count;

        private int[][] matrix;

        public int movingCount(int m, int n, int k) {
            if (k == 0) {
                return 1;
            }

            matrix = new int[m][n];
            innerHelper(0, 0, m, n, k);
            return count;
        }

        private void innerHelper(int x, int y, int m, int n, int k) {
            if (x >= m || y >= n || matrix[x][y] == 1 || getEveryNumSum(x) + getEveryNumSum(y) > k) {
                return;
            }

            count++;
            matrix[x][y] = 1;
            System.out.println(x + "," + y);
            innerHelper(x + 1, y, m, n, k);
            innerHelper(x, y + 1, m, n, k);
        }

        /**
         * 获取各个位数字之和
         */
        private int getEveryNumSum(int z) {
            int sum = 0;
            while (z > 0) {
                sum += z % 10;
                z /= 10;
            }

            return sum;
        }

    }

    /**
     * 广度优先遍历
     * <p>
     * time:O(mn)
     * space:O(mn)
     */
    private static class Solution2 {

        private static class Location {
            private int x;
            private int y;

            public Location(int x, int y) {
                this.x = x;
                this.y = y;
            }

            public int getX() {
                return x;
            }

            public void setX(int x) {
                this.x = x;
            }

            public int getY() {
                return y;
            }

            public void setY(int y) {
                this.y = y;
            }
        }

        public int movingCount(int m, int n, int k) {
            if (k == 0) {
                return 1;
            }

            int count = 0;
            boolean[][] matrix = new boolean[m][n];
            Queue<Location> nodeQueue = new LinkedList<>();
            nodeQueue.offer(new Location(0, 0));
            while (!nodeQueue.isEmpty()) {
                Location locationNow = nodeQueue.poll();
                if (locationNow.getX() >= m
                        || locationNow.getY() >= n
                        || matrix[locationNow.getX()][locationNow.getY()]
                        || getEveryNumSum(locationNow.getX()) + getEveryNumSum(locationNow.getY()) > k) {
                    continue;
                }

                count++;
                matrix[locationNow.getX()][locationNow.getY()] = true;
                nodeQueue.offer(new Location(locationNow.getX() + 1, locationNow.y));
                nodeQueue.offer(new Location(locationNow.getX(), locationNow.getY() + 1));
            }


            return count;
        }

        /**
         * 获取各个位数字之和
         */
        private int getEveryNumSum(int z) {
            int sum = 0;
            while (z > 0) {
                sum += z % 10;
                z /= 10;
            }

            return sum;
        }

    }

    /**
     * 递推
     * <p>
     * time:O(mn)
     * space:O(mn)
     */
    private static class Solution3 {

        public int movingCount(int m, int n, int k) {
            if (k == 0) {
                return 1;
            }

            int count = 0;
            boolean[][] matrix = new boolean[m][n];
            matrix[0][0] = true;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (getEveryNumSum(i) + getEveryNumSum(j) > k) {
                        continue;
                    }

                    if (i > 0) {
                        matrix[i][j] |= matrix[i - 1][j];
                    }

                    if (j > 0) {
                        matrix[i][j] |= matrix[i][j - 1];
                    }

                    count += matrix[i][j] ? 1 : 0;
                }
            }

            return count;
        }

        /**
         * 获取各个位数字之和
         */
        private int getEveryNumSum(int z) {
            int sum = 0;
            while (z > 0) {
                sum += z % 10;
                z /= 10;
            }

            return sum;
        }

    }

}
