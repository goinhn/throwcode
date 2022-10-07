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
