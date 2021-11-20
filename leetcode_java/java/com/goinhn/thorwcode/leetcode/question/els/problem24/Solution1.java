package com.goinhn.thorwcode.leetcode.question.els.problem24;

public class Solution1{
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode middle = new ListNode(-1);
        middle.next = head;
        ListNode result = middle;
        

        while(result.next != null && result.next.next != null){
            ListNode start = result.next;
            ListNode end = result.next.next;

            result.next = end;
            start.next = end.next;
            end.next = start;

            result = start;
        }

        return middle.next;
    }

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);

        ListNode list = new com.goinhn.leetcode.Solution1().swapPairs(head);

        while(list != null){
            System.out.println(list.val);
            list = list.next;
        }
    }
}



class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }
 