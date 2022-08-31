// Package _35 搜索插入位置
// @author goinhn
// @data 2022/8/31
package _35

// 根据二分进行改造
// time:O(logn)
// space:O(1)
func searchInsert1(nums []int, target int) int {
	left := 0
	right := len(nums) - 1
	res := len(nums)
	for left <= right {
		mid := left + (right-left)/2
		if nums[mid] < target {
			left = mid + 1
			res = left
		} else if nums[mid] > target {
			right = mid - 1
			res = mid
		} else {
			return mid
		}
	}

	return res
}

// 根据二分进行改造
// time:O(logn)
// space:O(1)
func searchInsert2(nums []int, target int) int {
	left := 0
	right := len(nums) - 1
	res := len(nums)
	for left <= right {
		mid := left + (right-left)/2
		if nums[mid] < target {
			left = mid + 1
		} else {
			right = mid - 1
			res = mid
		}
	}

	return res
}
