// Package _104 二叉树的最大深度
// @author goinhn
// @data 2022/8/20
package _104

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

// 深度优先搜索
// time:O(n)
// space:O(n)
func maxDepth1(root *TreeNode) (count int) {
	var dfsFunc func(root *TreeNode, level int)
	dfsFunc = func(root *TreeNode, level int) {
		if root == nil {
			return
		}

		if count < level {
			count = level
		}

		dfsFunc(root.Left, level+1)
		dfsFunc(root.Right, level+1)
	}

	dfsFunc(root, 1)
	return count
}

// 广度优先搜索
// time:O(n)
// space:O(n)
func maxDepth2(root *TreeNode) (count int) {
	if root == nil {
		return count
	}

	var queue []*TreeNode
	queue = append(queue, root)
	for len(queue) > 0 {
		sz := len(queue)
		for sz > 0 {
			node := queue[0]
			queue = queue[1:]
			if node.Left != nil {
				queue = append(queue, node.Left)
			}

			if node.Right != nil {
				queue = append(queue, node.Right)
			}

			sz--
		}
		count++
	}

	return count
}
