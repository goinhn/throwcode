// Package _852 山脉数组的峰顶索引
// @author goinhn
// @date 2022/8/31
package _852

// 遍历
// time:O(n)
// space:O(1)
func peakIndexInMountainArray1(arr []int) int {
	for i := 1; i < len(arr)-1; i++ {
		if arr[i] > arr[i-1] && arr[i] > arr[i+1] {
			return i
		}
	}

	return -1
}

// 二分
// time:O(logn)
// space:O(1)
func peakIndexInMountainArray2(arr []int) int {
	l := 0
	r := len(arr) - 1
	for l <= r {
		m := l + (r-l)/2
		if arr[m] <= arr[m+1] {
			l = m + 1
		} else if arr[m] <= arr[m-1] {
			r = m - 1
		} else {
			return m
		}
	}

	return -1
}
