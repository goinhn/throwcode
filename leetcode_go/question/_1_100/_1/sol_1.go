// Package _1 两数之和
// @author goinhn
// @date 2022/8/15
package _1

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

	hashTable := map[int]int{}
	for i, v := range nums {
		j, ok := hashTable[target-v]
		if ok {
			return []int{i, j}
		}
		hashTable[v] = i
	}

	return []int{}
}
