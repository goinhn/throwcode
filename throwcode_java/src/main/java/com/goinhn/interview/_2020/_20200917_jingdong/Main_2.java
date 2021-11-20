package com.goinhn.interview._2020._20200917_jingdong;

import java.util.Scanner;


public class Main_2 {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int count = Integer.parseInt(scanner.nextLine());

        for (int z = 0; z < count; z++) {
            String[] lineLength = scanner.nextLine().split(" ");
            int x = Integer.parseInt(lineLength[0]);
            int y = Integer.parseInt(lineLength[1]);
            int[][] arr = new int[x][y];

            int x1 = -1;
            int y1 = -1;
            int x2 = -1;
            int y2 = -1;
            for (int i = 0; i < x; i++) {
                String line = scanner.nextLine();
                for (int j = 0; j < line.length(); j++) {
                    if (line.charAt(j) == '#') {
                        arr[i][j] = -1;
                    }
                    if (line.charAt(j) == 'S') {
                        arr[i][j] = 2;
                        x1 = i;
                        y1 = j;
                    }
                    if (line.charAt(j) == 'E') {
                        arr[i][j] = 3;
                        x2 = i;
                        y2 = j;
                    }
                }
            }

            System.out.println(isLoop(arr, x1, y1, x2, y2));
        }


        scanner.close();
    }


    public static String isLoop(int[][] arr, int x1, int y1, int x2, int y2) {
        ran(arr, x1, y1);

        if (x2 - 1 >= 0 && arr[x2 - 1][y2] == 4
                || x2 + 1 < arr.length && arr[x2 + 1][y2] == 4
                || y2 - 1 >= 0 && arr[x2][y2 - 1] == 4
                || y2 + 1 < arr[0].length && arr[x2][y2 + 1] == 4) {
            return "YES";
        } else {
            return "NO";
        }
    }

    public static void ran(int[][] arr, int x, int y) {
        if (x < 0
                || x > arr.length - 1
                || y < 0
                || y > arr[0].length - 1
                || arr[x][y] == -1
//                || arr[x][y] == 2
                || arr[x][y] == 3
                || arr[x][y] == 4) {
            return;
        }

        if (arr[x][y] == 0) {
            arr[x][y] = 4;
        }

        ran(arr, x - 1, y);
        ran(arr, x + 1, y);
        ran(arr, x, y - 1);
        ran(arr, x, y + 1);
    }


}