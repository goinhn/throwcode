// Package _136 只出现一次的数字
// @author goinhn
// @data 2022/8/20
package _136

// set
// time:O(n)
// space:O(n)
func singleNumber1(nums []int) int {
	set := make(map[int]bool)

	for _, num := range nums {
		if _, isOk := set[num]; isOk {
			delete(set, num)
		} else {
			set[num] = true
		}
	}

	for i := range set {
		return i
	}
	return -1
}

// 异或
// time:O(n)
// space:O(1)
func singleNumber2(nums []int) (res int) {
	for _, num := range nums {
		res ^= num
	}

	return res
}
