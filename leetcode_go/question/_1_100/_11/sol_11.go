package _11

// 贪心
// time:O(n)
// space:O(1)
func maxArea(height []int) int {
	left := 0
	right := len(height) - 1
	ans := 0
	for left < right {
		hi := 0
		length := right - left
		if height[left] < height[right] {
			hi = height[left]
			left++
		} else {
			hi = height[right]
			right--
		}

		now := length * hi

		if ans < now {
			ans = now
		}
	}

	return ans
}
