package com.goinhn.interview._2020._20200412_netease;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main_1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int time = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < time; i++) {
            String lineFirst = scanner.nextLine();
            String[] lineFirstTemp = lineFirst.split(" ");
            int mode = Integer.parseInt(lineFirstTemp[0]);
            int length = Integer.parseInt(lineFirstTemp[1]);

            int[][] modes = new int[mode][mode];
            for (int j = 0; j < mode; j++) {
                String lineMiddle = scanner.nextLine();
                String[] lineMiddleTemp = lineMiddle.split(" ");
                for (int x = 0; x < lineMiddleTemp.length; x++) {
                    modes[j][x] = Integer.parseInt(lineMiddleTemp[x]);
                }
            }

            String lineLast = scanner.nextLine();
            String[] lineLastTemp = lineLast.split(" ");
            int x = Integer.parseInt(lineLastTemp[0]);
            int y = Integer.parseInt(lineLastTemp[1]);

            System.out.println(new Main_1().getFinalLength(length, modes, x, y));
        }
    }

    private int getFinalLength(int length, int[][] modes, int x, int y) {
        Map<String, Float> map = new HashMap<>();

        for (int i = 0; i < modes.length; i++) {
            for (int j = 0; j < modes[i].length; j++) {
                if (modes[i][j] != 0) {
                    float numL = Math.abs(x - i) * Math.abs(x - i) + Math.abs(y - j) * Math.abs(y - j);
                    numL = sqr(numL);
                    map.put(i + "," + j, numL);
                }
            }
        }


        boolean flag = true;
        String key = "";
        while (flag && !map.isEmpty()) {
            float min = modes.length * modes.length;
            Set<String> set = map.keySet();
            for (String s : set) {
                if (min > map.get(s)) {
                    min = map.get(s);
                    key = s;
                }
            }

            if (min <= length) {
                String[] los = key.split(",");
                int a = Integer.parseInt(los[0]);
                int b = Integer.parseInt(los[1]);
                length += modes[a][b];
                map.remove(key);
            } else {
                flag = false;
            }
        }


        return length;
    }

    private float sqr(float x) {
        float max = x;
        float min = 0;
        float middle = (max + min) / 2;

        while (true) {
            if (Math.abs(x - middle * middle) < 1) {
                return middle;
            }
            if (middle * middle > x) {
                max = middle;
            } else if (middle * middle < x) {
                min = middle;
            }
            middle = (min + max) / 2;
        }
    }

}

