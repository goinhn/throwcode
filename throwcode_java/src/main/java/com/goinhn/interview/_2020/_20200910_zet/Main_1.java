package com.goinhn.interview._2020._20200910_zet;

import java.util.*;

/**
 * <p>
 *  中兴通讯软件笔试
 *
 *
 * </p>
 *
 * @author goinhn
 * @date 2020-09-10T23:06:57
 */
public class Main_1 {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] picture = scanner.nextLine().split(" ");
        int n = Integer.parseInt(picture[0]);
        int m = Integer.parseInt(picture[1]);
        int x = Integer.parseInt(picture[2]);
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            String[] border = scanner.nextLine().split(" ");
            int n1 = Integer.parseInt(border[0]);
            int n2 = Integer.parseInt(border[1]);
            if(map.containsKey(n1)) {
                List<Integer> list = map.get(n1);
                list.add(n2);
                map.put(n1, list);
            }else {
                List<Integer> list = new ArrayList<>();
                list.add(n2);
                map.put(n1, list);
            }
        }

        int count = countBorder(n, m, x, map);
        System.out.println(addBorder(count));
        scanner.close();
    }

    public static int countBorder(int n, int m, int x, Map<Integer, List<Integer>> map) {
        Set<Integer> set = map.keySet();
        for (Integer integer : set) {

        }

        return -1;
    }

    public static int addBorder(int num) {
        return num - 1;
    }


}

