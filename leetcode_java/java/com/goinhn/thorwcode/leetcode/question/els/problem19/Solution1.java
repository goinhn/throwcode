//package com.goinhn.thorwcode.leetcode.question.els.problem19;
//
//public class Solution1{
//    public ListNode removeNthFromEnd(ListNode head, int n) {
//        ListNode dummy = new ListNode(0);
//        dummy.next = head;
//        ListNode temp = head;
//        int length = 0;
//        while(temp != null){
//            length ++;
//            temp = temp.next;
//        }
//
//        length -= n;
//        temp = dummy;
//
//        while(length > 0){
//            length --;
//            temp = temp.next;
//        }
//
//        temp.next = temp.next.next;
//
//        return dummy.next;
//    }
//}
//
///**
// * Definition for singly-linked list.
// * public class ListNode {
// *     int val;
// *     ListNode next;
// *     ListNode(int x) { val = x; }
// * }
// */