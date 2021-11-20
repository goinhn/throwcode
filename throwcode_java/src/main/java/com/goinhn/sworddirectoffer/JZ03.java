package com.goinhn.sworddirectoffer;

import java.util.ArrayList;
import java.util.Collections;

/**
 * <p>
 * 从尾到头打印一个链表
 * <p>
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 * </p>
 *
 * @author goinhn
 * @date 2020-12-05T14:36:26
 */
public class JZ03 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 先将顺序存储链表的结构，再将list的结构进行反转
     * <p>
     * complexity
     * time: O(n)
     * space: o(n)
     *
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        while (listNode != null) {
            list.add(listNode.val);
            listNode = listNode.next;
        }

        Collections.reverse(list);

        return list;
    }

}
