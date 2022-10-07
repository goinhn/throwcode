// Package _121 买卖股票的最佳时间
// @author goinhn
// @date 2022/8/20
package _121

// 遍历
// time:O(n)
// space:O(1)
func maxProfit(prices []int) int {
	minPrice := prices[0]
	maxGap := 0
	for _, price := range prices {
		if price < minPrice {
			minPrice = price
		} else if maxGap < price-minPrice {
			maxGap = price - minPrice
		}
	}

	return maxGap
}
