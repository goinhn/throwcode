package com.goinhn.thorwcode.leetcode.question._701_800;

import java.util.ArrayList;
import java.util.List;

/**
 * 735.行星碰撞
 *
 * @author goinhn
 * @date 2022/7/13
 */
public class Sol735 {

    /**
     * 模拟
     * time:O(n)
     * space:O(1)
     */
    private static class Solution1 {

        public int[] asteroidCollision(int[] asteroids) {
            for (int i = 0; i < asteroids.length; i++) {
                // 找出所有负或者正的进行模拟碰撞
                if (asteroids[i] < 0) {
                    for (int j = i - 1; j > -1; j--) {
                        if (asteroids[j] > 0) {
                            if (asteroids[j] < -asteroids[i]) {
                                asteroids[j] = 0;
                            } else if (asteroids[j] > -asteroids[i]) {
                                asteroids[i] = 0;
                                break;
                            } else {
                                asteroids[i] = 0;
                                asteroids[j] = 0;
                                break;
                            }
                        }
                    }
                }
            }

            List<Integer> res = new ArrayList<>();
            for (int asteroid : asteroids) {
                if (asteroid != 0) {
                    res.add(asteroid);
                }
            }

            return res.stream().mapToInt(i -> i).toArray();
        }

    }

}
