package com.goinhn.thorwcode.leetcode.competition.weeklycontest._268;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * @author goinhn
 * @date 2021/11/21
 */
public class Sol3 {

    private static class Solution1 {
        private static class Interval {
            int left;
            int right;

            public Interval(int left, int right) {
                this.left = left;
                this.right = right;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Interval interval = (Interval) o;
                return left == interval.left && right == interval.right;
            }

            @Override
            public int hashCode() {
                return Objects.hash(left, right);
            }
        }

        private Map<Interval, Map<Integer, Integer>> map = new HashMap<>();

        public void init(int[] arr) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = i; j < arr.length; j++) {
                    Interval interval = new Interval(i, j);
                    map.put(interval, new HashMap<>());
                    for (int x = i; x < j + 1; x++) {
                        map.get(interval).put(arr[x], map.get(interval).getOrDefault(arr[x], 0) + 1);
                    }
                }
            }
        }

        public Solution1(int[] arr) {
            init(arr);
        }

        public int query(int left, int right, int value) {
            Interval interval = new Interval(left, right);
            return Optional.ofNullable(map.get(interval).get(value)).orElse(0);
        }
    }

}
