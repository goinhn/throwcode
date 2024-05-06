// Package _1_100
// 两数之和
// @author goinhn
// @date 2022/8/15
package _1_100

// 暴力法
// time:O(n^2)
// space:O(1)
func twoSum1(nums []int, target int) []int {
	if nums == nil || len(nums) == 0 {
		return []int{}
	}

	for i, v := range nums {
		another := target - v
		for j := i + 1; j < len(nums); j++ {
			if another == nums[j] {
				return []int{i, j}
			}
		}
	}

	return []int{}
}

// hash table
// time:O(n)
// space:O(n)
func twoSum2(nums []int, target int) []int {
	if nums == nil || len(nums) == 0 {
		return []int{}
	}

	hashTable := make(map[int]int, len(nums))
	for i, v := range nums {
		if j, ok := hashTable[target-v]; ok {
			return []int{i, j}
		}
		hashTable[v] = i
	}

	return []int{}
}
