package com.goinhn.interview._2020._20200920_duxiaoman;

import java.util.Scanner;


/**
 * 坚强的小昆虫
 * 由于新冠肺炎疫信的爆发，小明养在宿舍的小昆虫已经很久很久都没有人管了。
 * 小昆虫已经饿的不行了，必须出来找东西吃，可是出来之后需要走出一个迷宫。
 * 小昆虫每次可以朝上、下、左、右四个方向之一走一步，且只要走出任意一条边界线即可逃出迷宫。
 * 这只小昆虫茜感染过X星的一种奇异病霉，目前还没有发现任何副作，但是却拥有了一项特异功能——破坏障碍物。
 * 假设小昆虫在一个N*M的迷宫中，”@“代表小昆虫的初始位置，“.”是代表可以通过的空地，代表可以破坏的障碍物，“#”代表不可破坏的蓮碍物。
 * 问小昆虫最少需要使用多少次特异功能才可以逃出迷宫？
 * <p>
 * 输入描述
 * 多组数据，第1行有1个正整数T，表示有T组数啹。（T<=100〕
 * 对于每组数据，第1行有两个整数N和M。(I<=N,M<=1000）
 * 接着N行，每行有一个长度为M的子付串，表示N*M的迷宫。
 * <p>
 * 输出描述
 * 输出一个整数，表示用特异功能的最少次数。如果小昆虫不能走出迷宫，则输出一1。
 * <p>
 * 样例输入
 * 3
 * 3 3
 * ###
 * #@*
 * ***
 * 3 4
 * ####
 * #@.*
 * **.*
 * 3 3
 * .#.
 * #@#
 * .#.
 * <p>
 * 输出样例
 * 1
 * 0
 * -1
 */
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