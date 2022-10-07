// Package _1694 重新格式化电话号码
// @author goinhn
// @data 2022/10/07
package _1694

import "strings"

// 模拟
// time:O(n)
// space:O(n)
func reformatNumber(number string) string {
	s := strings.ReplaceAll(number, " ", "")
	s = strings.ReplaceAll(s, "-", "")

	var ans []string
	i := 0
	for ; i+4 < len(s); i += 3 {
		ans = append(ans, s[i:i+3])
	}

	s = s[i:]
	if len(s) < 4 {
		ans = append(ans, s)
	} else {
		ans = append(ans, s[:2], s[2:])
	}

	return strings.Join(ans, "-")
}
