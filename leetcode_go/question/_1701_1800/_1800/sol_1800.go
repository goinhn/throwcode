// Package _1800 最大升序子数组和
// @author goinhn
// @date 2022/10/7
package _1800

// 模拟
// time:O(n)
// space:O(1)
func maxAscendingSum(nums []int) int {
	max := nums[0]
	sub := nums[0]
	for i := 0; i < len(nums)-1; i++ {
		if nums[i] < nums[i+1] {
			sub += nums[i+1]
			if sub > max {
				max = sub
			}
		} else {
			sub = nums[i+1]
		}
	}

	return max
}
