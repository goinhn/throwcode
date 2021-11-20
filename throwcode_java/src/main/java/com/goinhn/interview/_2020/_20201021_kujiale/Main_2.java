package com.goinhn.interview._2020._20201021_kujiale;


/**
 * <p>
 * 对一个链表记行排序
 * </p>
 *
 * @author goinhn
 * @date 2020-10-21T20:35:24
 */
public class Main_2 {
    static class LinkedList {
        int val;
        LinkedList next;

        public LinkedList(int val) {
            this.val = val;
        }
    }

    public static LinkedList getOrder(LinkedList head) {
        LinkedList temp = head;
        int size = 0;
        while (temp != null && temp.next != null) {
            size++;
            temp = temp.next;
        }

        for (int i = 0; i < size; i++) {

        }

        return head;
    }

}
