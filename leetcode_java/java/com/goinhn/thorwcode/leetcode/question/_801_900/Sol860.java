package com.goinhn.thorwcode.leetcode.question._801_900;

import java.util.HashMap;
import java.util.Map;

/**
 * 860.柠檬水找零
 *
 * @author goinhn
 * @date 2022/6/23
 */
public class Sol860 {

    /**
     * time:O()
     * space:O()
     */
    private static class Solution1 {

        private Map<Integer, Integer> moneyMap;

        public boolean lemonadeChange(int[] bills) {
            moneyMap = new HashMap<>();
            moneyMap.put(5, 0);
            moneyMap.put(10, 0);
            for (int bill : bills) {
                switch (bill) {
                    case 5: {
                        moneyMap.put(5, moneyMap.get(5) + 1);
                        break;
                    }
                    case 10: {
                        if (moneyMap.get(5) < 1) {
                            return false;
                        }
                        moneyMap.put(10, moneyMap.get(10) + 1);
                        moneyMap.put(5, moneyMap.get(5) - 1);
                        break;
                    }
                    case 20: {
                        if (moneyMap.get(10) > 0 && moneyMap.get(5) > 0) {
                            moneyMap.put(10, moneyMap.get(10) - 1);
                            moneyMap.put(5, moneyMap.get(5) - 1);
                        } else if (moneyMap.get(5) > 2) {
                            moneyMap.put(5, moneyMap.get(5) - 3);
                        } else {
                            return false;
                        }
                        break;
                    }
                    default:
                        break;
                }
            }

            return true;
        }

    }

}
