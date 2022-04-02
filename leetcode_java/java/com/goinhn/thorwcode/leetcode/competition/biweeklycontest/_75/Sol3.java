package com.goinhn.thorwcode.leetcode.competition.biweeklycontest._75;

/**
 * @author goinhn
 * @date 2022/4/2
 */
public class Sol3 {

    private static class Solution3 {
        public long numberOfWays(String s) {
            char[] sChars = s.toCharArray();
            int count = 0;
            for (int i = 0; i < sChars.length - 2; i++) {
                for (int j = i + 1; j < sChars.length -1; j++) {
                    if (sChars[i] == sChars[j]){
                        continue;
                    }
                    for (int x = j + 1; x < sChars.length; x++) {
                        if (sChars[j] != sChars[x]) {
                            count++;
                        }
                    }
                }
            }
            return count;
        }
    }
}
