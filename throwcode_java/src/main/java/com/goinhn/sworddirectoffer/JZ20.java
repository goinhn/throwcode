package com.goinhn.sworddirectoffer;

import java.util.Comparator;
import java.util.Stack;

/**
 * <p>
 * 包含min函数的栈
 * <p>
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 * </p>
 *
 * @author goinhn
 * @date 2020-12-09T20:23:08
 */
public class JZ20 {

    /**
     * 存放数据的栈
     */
    private Stack<Integer> stack = new Stack<>();

    /**
     * 使用一个辅助的栈来保存最小的元素，如果小于栈顶元素的话就将当前的元素入栈
     */
    private Stack<Integer> stackMin = new Stack<>();

    public void push(int node) {
        if (stackMin.isEmpty() || node <= stackMin.peek()) {
            stackMin.push(node);
        }
        stack.push(node);
    }

    /**
     *
     */
    public void pop() {
//        注意条件的检查
        if (stack.isEmpty()) {
            return;
        }

        if (stack.peek().equals(stackMin.peek())) {
            stackMin.pop();
        }
        stack.pop();
    }

    public int top() {
        if (stack.isEmpty()) {
            return -1;
        }

        return stack.peek();
    }

    public int min() {
        if (stackMin.isEmpty()) {
            return -1;
        }

        return stackMin.peek();
    }

}
