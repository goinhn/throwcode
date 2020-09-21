package com.goinhn.leetcode._1_100._1_10;

/**
 * <p>
 * 2. 两数相加
 * <p>
 * 时间复杂度 O(max(M+N))
 * 空间复杂度 O(max(M+N))
 * <p>
 * 遍历两个链表，每次当作数字相加考虑进位即可，注意最后一个进位容易被遗漏
 * </p>
 *
 * @author goinhn
 * @date 2020-08-29T20:16:12
 */
public class Solution_2_1 {

    /* Definition for singly-linked list. */
    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode t1 = l1;
        ListNode t2 = l2;
        ListNode l = new ListNode(0);
        ListNode lResult = l;
//        上一位的进位
        int carry = 0;

        while (t1 != null || t2 != null) {
            int x = (t1 == null) ? 0 : t1.val;
            int y = (t2 == null) ? 0 : t2.val;
            int sum = x + y + carry;
            carry = sum / 10;
            l.next = new ListNode(sum % 10);
            l = l.next;
            if (t1 != null) {
                t1 = t1.next;
            }
            if (t2 != null) {
                t2 = t2.next;
            }
        }

        if (carry > 0) {
            l.next = new ListNode(carry);
        }

        return lResult.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode list = new ListNode(0);
        list = new Solution_2_1().addTwoNumbers(l1, l2);
        while (list != null) {
            System.out.println(list.val);
            list = list.next;
        }
    }

}
