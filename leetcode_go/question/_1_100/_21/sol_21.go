// Package _21 合并两个有序链表
// @author goinhn
// @date 2022/8/16
package _21

type ListNode struct {
	Val  int
	Next *ListNode
}

// 顺序合并
// time:O(n)
// space:O(1)
func mergeTwoLists(list1 *ListNode, list2 *ListNode) *ListNode {
	if list1 == nil {
		return list2
	}

	if list2 == nil {
		return list1
	}

	preHead := &ListNode{Val: -1}
	pre := preHead
	for list1 != nil && list2 != nil {
		if list1.Val < list2.Val {
			pre.Next = list1
			list1 = list1.Next
		} else {
			pre.Next = list2
			list2 = list2.Next
		}
		pre = pre.Next
	}

	if list1 != nil {
		pre.Next = list1
	}

	if list2 != nil {
		pre.Next = list2
	}

	return preHead.Next
}
