// Package _94 二叉树的中序遍历
// @author goinhn
// @data 2022/8/19
package _94

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

// 递归遍历
// time:O(n)
// space:O(n)
func inorderTraversal1(root *TreeNode) (res []int) {
	var inOrderFunc func(root *TreeNode)
	inOrderFunc = func(root *TreeNode) {
		if root == nil {
			return
		}

		inOrderFunc(root.Left)
		res = append(res, root.Val)
		inOrderFunc(root.Right)
	}

	inOrderFunc(root)
	return res
}

// 递归遍历
// time:O(n)
// space:O(n)
func inorderTraversal2(root *TreeNode) []int {
	var res []int
	dfs(root, &res)

	return res
}

func dfs(root *TreeNode, res *[]int) {
	if root == nil {
		return
	}

	dfs(root.Left, res)
	*res = append(*res, root.Val)
	dfs(root.Right, res)
}

// 迭代遍历
// time:O(n)
// space:O(n)
func inorderTraversal3(root *TreeNode) []int {
	var res []int
	var stack []*TreeNode
	for root != nil || len(stack) > 0 {
		for root != nil {
			stack = append(stack, root)
			root = root.Left
		}

		root = stack[len(stack)-1]
		stack = stack[:len(stack)-1]
		res = append(res, root.Val)
		root = root.Right
	}

	return res
}
