// Package _1470 重新排列数组
// @author goinhn
// @date 2022/8/29
package _1470

// time:O(n)
// space:O(n)
func shuffle1(nums []int, n int) []int {
	res := make([]int, len(nums))
	left := 0
	right := n
	idx := 0
	for idx < len(nums) {
		res[idx] = nums[left]
		idx++
		left++
		res[idx] = nums[right]
		idx++
		right++
	}

	return res
}

// 通过多余的位来存储排序好的结果
// time:O(n)
// space:O(1)
func shuffle2(nums []int, n int) []int {
	for i := range nums {
		var j int
		if i < n {
			j = 2 * i
		} else {
			j = 2*(i-n) + 1
		}
		nums[j] |= (nums[i] & 1023) << 10
	}

	for i := range nums {
		nums[i] >>= 10
	}

	return nums
}
