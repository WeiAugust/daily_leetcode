package group.rookie;

/**
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/
 * 121. 买卖股票的最佳时机
 * 1 <= prices.length <= 10^5
 * 0 <= prices[i] <= 10^4
 * 思路：遍历数组，记录最小价格，如果当前价格减去最小价格大于最大利润值 则更新最大利润
 */
public class MaxProfit {
    public int maxProfit(int[] prices) {
        int ans = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > ans) {
                ans = prices[i] - minPrice;
            }
        }
        return ans;
    }
}
