package com.goinhn.interview._2020._20200909_bytedance;

/**
 * <p>
 * 题目：
 * 判断一个链表是否有环，如果存在环的返回环相交的节点
 * 空间复杂度为O(1)
 * <p>
 * 时间复杂度:O(N)
 * 空间复杂度:O(1)
 * </p>
 *
 * @author goinhn
 * @date 2020-09-11T00:46:59
 */
public class Main_3 {

    static class Node {
        Node next;
        int value;
    }

    /**
     * 先通过双指针来判断是否存在环，如果存在环的话，该环相遇的地点和头节点到环相交处的距离是一样的
     * <p>
     *
     * @param head
     * @return
     */
    public static Node loopMeet(Node head) {
        Node node1 = head;
        Node node2 = head;

        while (node1 != null) {
            node1 = node1.next.next;
            node2 = node2.next;
            if (node1 == node2) {
                node1 = head;
                // 存在环则一个指向头节点一个指向相遇点继续走即可
                while (node1 != node2) {
                    node1 = node1.next;
                    node2 = node2.next;
                }

                return node1;
            }
        }

        return null;
    }


}
