package com.goinhn.sworddirectoffer;

import java.util.Stack;

/**
 * <p>
 * 用两个栈实现队列
 * <p>
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * </p>
 *
 * @author goinhn
 * @date 2020-12-08T12:02:36
 */
public class JZ05 {

    /**
     * push stack
     */
    Stack<Integer> stack1 = new Stack<Integer>();
    /**
     * pop stack
     */
    Stack<Integer> stack2 = new Stack<Integer>();

    /**
     * 入队列直接进入push stack
     *
     * @param node
     */
    public void push(int node) {
        stack1.push(node);
    }

    /**
     * 出队列的时候要判断pop stack是否为空，不为空直接返回栈顶的值，如果为空将push stack中的元素出栈入栈到该栈中
     *
     * @return
     */
    public int pop() {
        int result = -1;
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        result = stack2.pop();
        return result;
    }
}
