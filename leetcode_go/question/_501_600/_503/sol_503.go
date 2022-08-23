// Package _503 下一个更大元素II
// @author goinhn
// @data 2022/8/23
package _503

// 单调栈
// time:O(n)
// space:O(n)
func nextGreaterElements(nums []int) []int {
	n := len(nums)
	res := make([]int, n)
	for i := range res {
		res[i] = -1
	}

	var stack []int
	for i := 0; i < n*2-1; i++ {
		for len(stack) > 0 && nums[stack[len(stack)-1]] < nums[i%n] {
			res[stack[len(stack)-1]] = nums[i%n]
			stack = stack[:len(stack)-1]
		}
		stack = append(stack, i%n)
	}

	return res
}
