package com.goinhn.interview._2020._20200909_bytedance;

/**
 * <p>
 * 字节跳动测试开发工程师一面算法
 * <p>
 * 题目：
 * 判断一个链表是否有环
 * 空间复杂度为O(1)
 * <p>
 * 时间复杂度:O(N)
 * 空间复杂度:O(1)
 * </p>
 *
 * @author goinhn
 * @date 2020-09-10T23:11:17
 */
public class Main_1 {

    static class Node {
        Node next;
        int value;
    }

    /**
     * 设置两个指针，第一个指针每次走两个，第二个指针每次走一个，如果存在环的话则两个指针最后回相遇
     * <p>
     * 因为两指针时间的距离始终是扩大一个位置或者缩小一个位置，进入环中会进行循环，不同的缩小接近或者扩大离开，一定存在相遇的一刻
     *
     * @param head
     * @return
     */
    public static boolean isLoop(Node head) {
        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }

        return false;
    }

}
