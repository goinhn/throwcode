// Package _1_100
// @author goinhn
// @date 2024/5/7
package _1_100

// 左右部分比较是否相等
// time:O(n)
// space:O(1)
func isPalindrome1(x int) bool {
	if x < 0 {
		return false
	}
	if x%10 == 0 && x != 0 {
		return false
	}
	reverse := 0
	for reverse < x {
		reverse = reverse*10 + x%10
		x = x / 10
	}
	return x == reverse || x == reverse/10
}
