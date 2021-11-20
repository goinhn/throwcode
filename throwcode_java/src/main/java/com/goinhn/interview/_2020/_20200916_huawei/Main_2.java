package com.goinhn.interview._2020._20200916_huawei;

import java.util.*;

public class Main_2 {

    private static final Scanner scanner = new Scanner(System.in);

    static class Graph {
        int val;
        List<Integer>[] list;

        Graph(int val) {
            this.val = val;
            list = new LinkedList[val];
            for (int i = 0; i < val; i++) {
                list[i] = new LinkedList<>();
            }
        }
    }

    public static void addEdge(Graph graph, int src, int dest) {
        graph.list[src].add(dest);
        graph.list[dest].add(src);
    }

    public static void isMiddle(Graph graph, int left, int right, int size) {
//        Set<Integer> set = new HashSet<>();
//        set.add(left);
//        List<Integer> list = graph.list[left];

        if (graph.list[left].size() != graph.list[right].size()) {
            System.out.println(0);
        } else {
            int result = 0;
            for (Integer integer : graph.list[left]) {
                result += integer;
            }
            System.out.println(result);
        }
    }

    public static void main(String[] args) {
        int left = scanner.nextInt() - 1;
        int right = scanner.nextInt() - 1;
        int count = scanner.nextInt();

        int max = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < count; i++) {
            int src = scanner.nextInt();
            int dest = scanner.nextInt();
            List<Integer> list = map.getOrDefault(src, new ArrayList<>());
            list.add(dest);
            map.put(src, list);
            max = Math.max(max, src);
            max = Math.max(max, dest);
        }

        Graph graph = new Graph(max);

        Set<Integer> set = map.keySet();
        for (Integer integer : set) {
            List<Integer> list = map.get(integer);
            for (Integer integer1 : list) {
                graph.list[integer - 1].add(integer1 - 1);
                graph.list[integer1 - 1].add(integer - 1);
            }
        }

        isMiddle(graph, left, right, max);


        scanner.close();
    }


}