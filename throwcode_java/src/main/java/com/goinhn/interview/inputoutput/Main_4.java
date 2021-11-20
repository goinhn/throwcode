package com.goinhn.interview.inputoutput;

import java.util.Scanner;

public class Main_4 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n;
        while (0 != (n = sc.nextInt())) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += sc.nextInt();
            }
            System.out.println(sum);
        }
    }

    private void test() {
        Scanner scanner = new Scanner(System.in);
        int n;
        while(!scanner.hasNext("0")) {
            int length = scanner.nextInt();
            int sum = 0;
            for(int i = 0; i < length; i++) {
                sum += scanner.nextInt();
            }
            System.out.println(sum);
        }
    }
}
