package com.goinhn.interview._2020._20201009_yonghang;

import java.util.Scanner;

/**
 * 永航科技笔试
 *
 * 对单链表进行去重
 *
 */
public class Main_1 {

    private static final Scanner scanner = new Scanner(System.in);

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        ListNode now = new ListNode(0);
        now.next = new ListNode(1);
        now.next.next = new ListNode(1);
        now.next.next.next = new ListNode(3);

        now = deleteDuplicates(now);

        while (now != null) {
            System.out.println(now.val);
            now = now.next;
        }
        scanner.close();
    }


    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;

        }

        ListNode result = head;
        int tempValue = head.val;
        while (head.next != null) {
            int value = head.next.val;
            if (tempValue == value) {
                head.next = head.next.next;
            } else {
                tempValue = value;
                head = head.next;
            }
        }

        return result;
    }


}

