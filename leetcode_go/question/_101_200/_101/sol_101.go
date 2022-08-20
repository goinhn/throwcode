// Package _101 对称二叉树
// @author goinhn
// @data 2022/8/20
package _101

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

// 深度优先搜索
// time:O(n)
// space:O(n)
func isSymmetric(root *TreeNode) bool {
	if root == nil {
		return true
	}

	return dfs(root.Left, root.Right)
}

func dfs(leftNode *TreeNode, rightNode *TreeNode) bool {
	if leftNode == nil && rightNode == nil {
		return true
	}

	if leftNode == nil || rightNode == nil {
		return false
	}

	if leftNode.Val != rightNode.Val {
		return false
	} else {
		// 左右两侧相互比较
		return dfs(leftNode.Left, rightNode.Right) && dfs(leftNode.Right, rightNode.Left)
	}
}
