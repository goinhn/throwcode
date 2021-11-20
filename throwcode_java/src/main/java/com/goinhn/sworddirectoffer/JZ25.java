package com.goinhn.sworddirectoffer;

/**
 * <p>
 * 复杂链表的复制
 * <p>
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针random指向一个随机节点），请对此链表进行深拷贝，并返回拷贝后的头结点。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 * </p>
 *
 * @author goinhn
 * @date 2020-12-14T20:11:03
 */
public class JZ25 {

    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    public RandomListNode Clone(RandomListNode pHead) {
        if(pHead == null) {
            return null;
        }
        RandomListNode headTemp = pHead;
        RandomListNode resultList = new RandomListNode(headTemp.label);
        RandomListNode resultListTemp = resultList;
        while(headTemp.next != null) {
            resultListTemp.next = new RandomListNode(headTemp.next.label);
            if(headTemp.random != null) {
                resultListTemp.random = new RandomListNode(headTemp.random.label);
            }
            resultListTemp = resultListTemp.next;
            headTemp = headTemp.next;
        }

        return resultList;
    }

}
