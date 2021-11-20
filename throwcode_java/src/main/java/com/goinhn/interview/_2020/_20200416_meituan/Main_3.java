package com.goinhn.interview._2020._20200416_meituan;//import java.util.*;
//
//public class Main {
//
//    private static final Scanner scanner = new Scanner(System.in);
//
//    public static void main(String[] args) {
//        while (scanner.hasNext()) {
//            String[] line = scanner.nextLine().split(" ");
//            int n = Integer.parseInt(line[0]);
//            int k = Integer.parseInt(line[1]);
//            Set<Integer> set = new TreeSet<>();
//            List<Integer> list = new ArrayList<>();
//
//            String[] lineNumber = scanner.nextLine().split(" ");
//            for (int i = 0; i < n; i++) {
//                int temp = Integer.parseInt(lineNumber[i]);
//                if (!set.contains(temp)) {
//                    set.add(temp);
//                } else {
//                    list.add(temp);
//                }
//            }
//
//            System.out.println(new Main().shuDui(set, list, k));
//        }
//        scanner.close();
//    }
//
//
//    private String shuDui(Set<Integer> set, List<Integer> list, int k) {
//
//        int size = set.size();
//
//        Map<Integer, Integer> map = new HashMap<>(size);
//        for(int i = 0; i < size; i++){
//            boolean flag = false;
//            for (Integer integer : list) {
//                if(integer == i){
//                    flag = true;
//                }
//            }
//            if(flag){
//                map.put(i, size + 1);
//            }else {
//                map.put(i, size);
//            }
//        }
//
//        int temp = k;
//        int x= 0;
//        Set<Integer> setKey = map.keySet();
//        for (Integer integer : setKey) {
//            if(temp > map.get(integer)){
//                temp -= map.get(integer);
//                x = integer;
//            }
//        }
//
//
//        List<Integer> listNow = new ArrayList<>(set);
//        int nowSize = map.get(x);
//        if(nowSize > size){
//
//        }
//
//        return "(" + x + "," + y + ")";
//    }
//
//
//}
