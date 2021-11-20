package com.goinhn.interview._2020._20200920_meituan;

import java.util.Scanner;

public class Main_2 {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] line = scanner.nextLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        int p = Integer.parseInt(line[2]);
        int q = Integer.parseInt(line[3]);
        char[][] arr = new char[n][m];
        int x = -1;
        int y = -1;

        for (int i = 0; i < n; i++) {
            char[] now = scanner.nextLine().toCharArray();
            for (int j = 0; j < now.length; j++) {
                if (now[j] == 'S') {
                    x = i;
                    y = j;
                    now[j] = '+';
                }
            }
            arr[i] = now;
        }

        char[] route = scanner.nextLine().toCharArray();

        System.out.println(score(arr, x, y, p, q, route));

        scanner.close();
    }

    public static int score(char[][] arr, int x, int y, int p, int q, char[] route) {
        int score = 0;

        for (char c : route) {
            if (c == 'W') {
                if (x - 1 > 0 && arr[x - 1][y] != '#') {
                    if (arr[x - 1][y] == 'O') {
                        score = score + p;
                    } else if (arr[x - 1][y] == 'X') {
                        score = score - q;
                    }
                    arr[x - 1][y] = '+';
                    x = x - 1;
                }
            } else if (c == 'A') {
                if (y - 1 > 0 && arr[x][y - 1] != '#') {
                    if (arr[x][y - 1] == 'O') {
                        score = score + p;
                    } else if (arr[x][y - 1] == 'X') {
                        score = score - q;
                    }
                    arr[x][y - 1] = '+';
                    y = y - 1;
                }
            } else if (c == 'S') {
                if (x + 1 < arr.length && arr[x + 1][y] != '#') {
                    if (arr[x + 1][y] == 'O') {
                        score = score + p;
                    } else if (arr[x + 1][y] == 'X') {
                        score = score - q;
                    }
                    arr[x + 1][y] = '+';
                    x = x + 1;
                }
            } else if (c == 'D') {
                if (y + 1 < arr[0].length && arr[x][y + 1] != '#') {
                    if (arr[x][y + 1] == 'O') {
                        score = score + p;
                    } else if (arr[x][y + 1] == 'X') {
                        score = score - q;
                    }
                    arr[x][y + 1] = '+';
                    y = y + 1;
                }
            }
        }

        return score;
    }


}