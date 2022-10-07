// Package _921 使括号有效的最少添加
// @author goinhn
// @data 2022/10/07
package _921

// 贪心匹配
// time:O(n)
// space:O(1)
func minAddToMakeValid(s string) int {
	ans := 0
	leftCount := 0
	for _, c := range s {
		if c == '(' {
			leftCount++
		} else {
			if leftCount > 0 {
				leftCount--
			} else {
				ans++
			}
		}
	}

	ans += leftCount
	return ans
}
