package com.goinhn.thorwcode.leetcode.competition.weeklycontest._270;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author goinhn
 * @date 2021/11/28
 */
public class Sol1 {
    private static class Solution1 {
        public int[] findEvenNumbers(int[] digits) {
            List<Integer> list = Arrays.stream(digits).distinct().sorted().boxed().collect(Collectors.toList());
            List<Integer> result = new ArrayList<>();
            for (Integer x : list) {
                if (x == 0) {
                    continue;
                }
                for (Integer y : list) {
                    if (y.equals(x)) {
                        continue;
                    }
                    for (Integer z : list) {
                        if (z.equals(y) || z.equals(x))
                        if (z % 2 != 0) {
                            continue;
                        }
                        result.add(x * 100 + y * 10 + z);
                    }
                }
            }

            return result.stream().mapToInt(Integer::valueOf).toArray();
        }
    }
}
