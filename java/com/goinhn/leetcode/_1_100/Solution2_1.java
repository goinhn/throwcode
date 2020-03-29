package com.goinhn.leetcode._1_100;

public class Solution2_1 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode list = new ListNode(0);
        list = new Solution2_1().addTwoNumbers(l1, l2);
        while (list != null) {
            System.out.println(list.val);
            list = list.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode list = new ListNode(0);
        ListNode t1 = l1;
        ListNode t2 = l2;
        ListNode temp = list;
//        上一位的进位
        int carry = 0;

        while (t1 != null || t2 != null) {
            int x = (t1 == null) ? 0 : t1.val;
            int y = (t2 == null) ? 0 : t2.val;
            int sum = x + y + carry;
            carry = sum / 10;
            temp.next = new ListNode(sum % 10);
            temp = temp.next;
            if (t1 != null) {
                t1 = t1.next;
            }
            if (t2 != null) {
                t2 = t2.next;
            }
        }

        if (carry > 0) {
            temp.next = new ListNode(carry);
        }

        return list.next;
    }

}

/* Definition for singly-linked list. */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}