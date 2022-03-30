package com.goinhn.throwcode.codinginterviews.liked_list;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 6.从尾到头打印一个链表
 *
 * @author goinhn
 * @date 2020-12-05T14:36:26
 */
public class Jz6 {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 辅助栈
     * time:O(n)
     * space:O(n)
     */
    private static class Solution1 {
        public int[] reversePrint(ListNode head) {
            Stack<Integer> stack = new Stack<>();
            while (head != null) {
                stack.push(head.val);
                head = head.next;
            }

            int[] result = new int[stack.size()];
            for (int i = 0; i < result.length; i++) {
                result[i] = stack.pop();
            }
            return result;
        }
    }

    /**
     * 递归
     * time:O(n)
     * space:O(n)
     */
    private static class Solution2 {
        private final List<Integer> list = new ArrayList<>();

        public int[] reversePrint(ListNode head) {
            reverseHelper(head);

            int[] result = new int[list.size()];
            for (int i = 0; i < result.length; i++) {
                result[i] = list.get(i);
            }
            return result;
        }

        public void reverseHelper(ListNode head) {
            if (head == null) {
                return;
            }
            reverseHelper(head.next);
            list.add(head.val);
        }
    }

}
