// Package _496 下一个更大元素I
// @author goinhn
// @date 2022/8/22
package _496

// 遍历
// time:O(n)
// space:O(1)
func nextGreaterElement1(nums1 []int, nums2 []int) []int {
	res := make([]int, len(nums1))
	for i, num1 := range nums1 {
		isNum := false
		isMax := false
		for _, num2 := range nums2 {
			if num1 == num2 {
				isNum = true
			}

			if isNum && num2 > num1 {
				res[i] = num2
				isMax = true
				break
			}
		}

		if !isMax {
			res[i] = -1
		}
	}

	return res
}

// 单调栈
// time:O(n)
// space:O(1)
func nextGreaterElement2(nums1 []int, nums2 []int) []int {
	hashTable := map[int]int{}
	var stack []int
	for i := len(nums2) - 1; i > -1; i-- {
		for len(stack) > 0 && nums2[i] > stack[len(stack)-1] {
			stack = stack[:len(stack)-1]
		}

		if len(stack) == 0 {
			hashTable[nums2[i]] = -1
		} else {
			hashTable[nums2[i]] = stack[len(stack)-1]
		}

		stack = append(stack, nums2[i])
	}

	res := make([]int, len(nums1))
	for i, num := range nums1 {
		res[i] = hashTable[num]
	}

	return res
}
