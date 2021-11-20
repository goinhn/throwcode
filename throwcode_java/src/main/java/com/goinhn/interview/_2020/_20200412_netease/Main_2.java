package com.goinhn.interview._2020._20200412_netease;

import java.util.*;

public class Main_2 {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int time = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < time; i++) {
            String lineFirst = scanner.nextLine();
            int N = Integer.parseInt(lineFirst.split(" ")[0]);
            int M = Integer.parseInt(lineFirst.split(" ")[1]);
            new Main_2().getThree(N, M);

        }
    }

    private void getThree(int N, int M) {
        for (int i = 0; i < M; i++) {
            String lineMiddle = scanner.nextLine();
            String[] lineMiddles = lineMiddle.split(" ");
            List<Integer> list = new ArrayList<>();

            for (int j = 0; j < lineMiddles.length; j++) {
                list.add(Integer.parseInt(lineMiddles[j]));
            }

            Map<Integer, List<Integer>> map = new HashMap<>();
            int zuo = list.get(0);

            switch (zuo) {
                case 1:
                    if (map.isEmpty()) {
                        List<Integer> listNei = new ArrayList<>();
                        listNei.add(list.get(1));
                        listNei.add(list.get(2));
                        map.put(i, listNei);
                    } else {
                        Set<Integer> set = map.keySet();
                        int begin = -1;
                        int end = -1;
                        for (Integer integer : set) {
                            int first = -1;
                            int last = -1;
                            List<Integer> listTemp = map.get(integer);
                            for (int j = 0; j < listTemp.size(); j++) {
                                if (list.get(1) == listTemp.get(j)) {
                                    first = j;
                                    break;
                                }
                            }
                            for (int j = 0; j < listTemp.size(); j++) {
                                if (list.get(2) == listTemp.get(j)) {
                                    last = j;
                                    break;
                                }
                            }
                            if (first != -1 && last != -1 && first != last) {
                                break;
                            }
                            if (first != -1) {
                                begin = integer;
                            }
                            if (last != -1) {
                                end = integer;
                            }
                        }

                        if (begin != -1 && end != -1) {
                            map.get(begin).addAll(map.get(end));
                            map.remove(end);
                        }
                    }
                    break;

                case 2:
                    if (map.isEmpty()) {
                        List<Integer> listNei = new ArrayList<>();
                        listNei.add(list.get(1));
                        map.put(i, listNei);
                    } else {
                        Set<Integer> set = map.keySet();
                        int size = 0;
                        int flag = -1;
                        int lo = -1;

                        for (Integer integer : set) {
                            List<Integer> listTemp = map.get(integer);

                            for (int j = 0; j < listTemp.size(); j++) {
                                if (listTemp.get(j) == list.get(1)) {
                                    size = listTemp.size();
                                    flag = integer;
                                    lo = j;
                                    break;
                                }
                            }
                            if (flag != -1) {
                                break;
                            }

                        }

                        if (flag != -1) {
                            if (size != 1) {
                                int max = -1;
                                for (Integer integer : set) {
                                    if (max < integer) {
                                        max = integer + 1;
                                    }
                                }
                                map.get(flag).remove(lo);
                                List<Integer> newList = new ArrayList<>();
                                newList.add(list.get(1));
                                map.put(max, newList);
                            }
                        }
                    }

                    break;
                case 3:
                    Set<Integer> set = map.keySet();
                    int num = -1;
                    for (Integer integer : set) {
                        for (int j = 0; j < map.get(integer).size(); j++) {
                            if (list.get(1) == map.get(integer).get(j)) {
                                num = map.get(integer).size();
                                break;
                            }
                        }
                        if (num != -1) {
                            break;
                        }
                    }
                    if (num != -1) {
                        System.out.println(num);
                    }

                    break;
            }
        }
    }

}

