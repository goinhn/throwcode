// Package _334 递增的三元子序列
// @author goinhn
// @date 2022/10/14
package _334

import "math"

// 贪心
// time:O(n)
// space:O(1)
func increasingTriplet(nums []int) bool {
	first := nums[0]
	second := math.MaxInt32
	for _, num := range nums {
		if num <= first {
			first = num
		} else if num <= second {
			second = num
		} else {
			return true
		}
	}

	return false
}
