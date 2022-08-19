// Package _1450 在既定时间做作业的学生人数
// @author goinhn
// @data 2022/8/19
package _1450

// 遍历
// time:O(n)
// space:O(1)
func busyStudent(startTime []int, endTime []int, queryTime int) int {
	if startTime == nil || len(startTime) == 0 || endTime == nil || len(endTime) == 0 {
		return 0
	}

	count := 0
	for i := 0; i < len(startTime); i++ {
		if startTime[i] <= queryTime && endTime[i] >= queryTime {
			count++
		}
	}

	return count
}
