package com.goinhn.interview._2020._20200909_bytedance;

/**
 * <p>
 * 判断两个无环链表是否有交点
 * <p>
 * 时间复杂度:O(N)
 * 空间复杂度:O(1)
 * </p>
 *
 * @author goinhn
 * @date 2020-09-11T00:59:45
 */
public class Main_4 {

    static class Node {
        Node next;
        int value;
    }

    /**
     * 将其中一个链表变成环，则问题变成判断链表中是否存在环
     *
     * @param headA
     * @param headB
     * @return
     */
    public static boolean isMeet(Node headA, Node headB) {
        Node headX = headA;
        Node headY = headB;
        Node temp = headB;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = headB;

        Node headZ = headA;
        while (headZ != null) {
            headX = headX.next;
            headZ = headZ.next.next;

            if (headX == headZ) {
                temp.next = null;
                return true;
            }
        }

        temp.next = null;
        return false;
    }


}
