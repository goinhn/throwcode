package _921

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
