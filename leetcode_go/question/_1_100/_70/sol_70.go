// Package _70 爬楼梯
// @author goinhn
// @data 2022/8/19
package _70

// 动态规划
// time:O(n)
// space:O(1)
func climbStairs(n int) int {
	if n < 3 {
		return n
	}

	first := 1
	second := 2
	for i := 3; i <= n; i++ {
		first, second = second, first+second
	}

	return second
}
