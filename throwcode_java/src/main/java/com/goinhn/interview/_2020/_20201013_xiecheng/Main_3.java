package com.goinhn.interview._2020._20201013_xiecheng;

import java.util.Scanner;

public class Main_3 {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int count = Integer.parseInt(scanner.nextLine());
        String str = scanner.nextLine();
        String ipre = str.split("\\[")[0];
        if (ipre.length() == 1 && "a".equals(ipre) || ipre.length() == 5 && "array".equals(ipre)) {
            int index;
            if (str.length() < 5) {
                index = 0;
            } else {
                String begin = str.substring(0, 5);
                index = "array".equals(begin) ? 5 : 0;
            }
            int size = Integer.parseInt(str.substring(index + 2, str.length() - 1));
            for (int i = 1; i < count; i++) {
                String now = scanner.nextLine();
                String pre = now.split("=")[0];
                String aft = now.split("=")[1];
                int preSize = Integer.parseInt(pre.substring(index + 2, pre.length() - 1));

                if (preSize > size) {
                    System.out.println(i + 1);
                    break;
                }

                if (aft.charAt(aft.length() - 1) == ']') {
                    int aftSize = Integer.parseInt(aft.substring(index + 2, aft.length() - 1));
                    if (aftSize > size) {
                        System.out.println(i + 1);
                        break;
                    }
                }
            }
        } else {
            System.out.println(1);
        }


        scanner.close();
    }

}

