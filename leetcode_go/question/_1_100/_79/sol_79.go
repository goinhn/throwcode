// Package _79 最大数
// @author goinhn
// @date 2022/10/12
package _79

import (
	"sort"
	"strconv"
)

// 定义比较器进行排序
// time:O(nlogn)
// space:O(n)
func largestNumber(nums []int) string {
	sort.Slice(nums, func(i, j int) bool {
		x, y := nums[i], nums[j]
		sx, sy := 10, 10
		for sx <= x {
			sx *= 10
		}
		for sy <= y {
			sy *= 10
		}
		return sy*x+y > sx*y+x
	})
	if nums[0] == 0 {
		return "0"
	}
	var ans []byte
	for _, x := range nums {
		ans = append(ans, strconv.Itoa(x)...)
	}
	return string(ans)
}
