package com.goinhn.algorithm.linkedalg;

/**
 * <p>
 * 两数相加
 * <p>
 * 给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表
 * </p>
 *
 * @author goinhn
 * @date 2020-12-03T21:27:29
 */
public class TwoSum {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode addWTwoNumbers(ListNode l1, ListNode l2) {
//        新建新的结果链表
        ListNode dummyHead = new ListNode(0);
//        缓存指针
        ListNode p1 = l1, p2 = l2, curr = dummyHead;

//        进位的数字部分
        int carry = 0;
        while (p1 != null && p2 != null) {
            int sum = carry + p1.val + p2.val;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            p1 = p1.next;
            p2 = p2.next;
        }

        while (p1 != null) {
            int sum = carry + p1.val;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            p1 = p1.next;
        }

        while (p2 != null) {
            int sum = carry + p2.val;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            p2 = p2.next;
        }

//        将最后多余的进位添加进去
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }

        return dummyHead.next;
    }


}
