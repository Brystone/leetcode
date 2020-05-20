package leetcode.dp;

/**
 * 题目：121. Best Time to Buy and Sell Stock
 * Input: [7,1,5,3,6,4]
 * Output:
 * @author ：stone
 * @date ：Created in 2020/1/31 21:09
 */
public class BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i]; //找到最小的数
            if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice; //更新最大的利润
        }
        return maxprofit;
    }
}
