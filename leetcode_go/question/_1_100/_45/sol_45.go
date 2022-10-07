package _45

// 贪心
// time:O(n)
// space:O(1)
func jump(nums []int) int {
	step := 0
	maxPos := 0
	end := 0
	for i := 0; i < len(nums)-1; i++ {
		if maxPos < i+nums[i] {
			maxPos = i + nums[i]
		}
		if i == end {
			end = maxPos
			step++
		}
	}

	return step
}
