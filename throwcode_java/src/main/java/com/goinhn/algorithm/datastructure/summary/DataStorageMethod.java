package com.goinhn.algorithm.datastructure.summary;

/**
 * <p>
 * 数据结构存储的方式
 * - 数组（顺序存储） array
 * - 链表（链式存储） linked list
 * <p>
 * 数组由于是紧凑连续存储,可以随机访问，通过索引快速找到对应元素，而且相对节约存储空间。
 * 但正因为连续存储，内存空间必须一次性分配够，所以说数组如果要扩容，需要重新分配一块更大的空间，再把数据全部复制过去，时间复杂度 O(N)；
 * 而且你如果想在数组中间进行插入和删除，每次必须搬移后面的所有数据以保持连续，时间复杂度 O(N)。
 * <p>
 * 链表因为元素不连续，而是靠指针指向下一个元素的位置，所以不存在数组的扩容问题；
 * 如果知道某一元素的前驱和后驱，操作指针即可删除该元素或者插入新元素，时间复杂度 O(1)。
 * 但是正因为存储空间不连续，你无法根据一个索引算出对应元素的地址，所以不能随机访问；
 * 而且由于每个元素必须存储指向前后元素位置的指针，会消耗相对更多的储存空间。
 * <p>
 * 数组和链表是底层结构基础，所有复杂的操作都可以转变为在数组和链表上的操作
 *
 *
 * </p>
 *
 * @author goinhn
 * @date 2021-01-12T00:34:15
 */
public class DataStorageMethod {

    /*
        基本数据结构的遍历方式
     */

    /**
     * 遍历数组的方式
     *
     * @param arr
     */
    public void traverseArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // access arr[i]
        }
    }

    /**
     * 链表节点
     */
    class ListNode {
        int val;
        ListNode next;
    }

    /**
     * 遍历访问链表，非递归方式
     *
     * @param head
     */
    public void traverseLinkedList(ListNode head) {
        for (ListNode p = head; p != null; p = p.next) {
            // access p
        }
    }

    /**
     * 遍历访问链表，递归的方式
     *
     * @param head
     */
    public void traverseLinkedListRecursion(ListNode head) {
        // access head
        traverseLinkedListRecursion(head);
    }

    /**
     * 二叉树节点
     */
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    /**
     * 遍历二叉树递归的方式
     *
     * @param root
     */
    public void traverseTreeNode(TreeNode root) {
        // access left/right
        traverseTreeNode(root.left);
        traverseTreeNode(root.right);
    }

    /**
     * 多叉树节点
     */
    class TreeNodes {
        int val;
        TreeNodes[] children;
    }

    /**
     * 遍历N叉树
     *
     * @param root
     */
    public void traverseTreeNodes(TreeNodes root) {
        for (int i = 0; i < root.children.length; i++) {
            // access root.children[i]
            traverseTreeNodes(root.children[i]);
        }
    }

    /*
        图就是好几个N叉树的结合体，访问过的节点使用boolean[] visited存储
     */
}

