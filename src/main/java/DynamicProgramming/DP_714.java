package DynamicProgramming;

/**
Your are given an array of integers prices, for which the i-th element is the price of a given stock on day i; and a non-negative integer fee representing a transaction fee.

You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction. You may not buy more than 1 share of a stock at a time (ie. you must sell the stock share before you buy again.)

Return the maximum profit you can make.

Example 1:
Input: prices = [1, 3, 2, 8, 4, 9], fee = 2
Output: 8
Explanation: The maximum profit can be achieved by:
Buying at prices[0] = 1
Selling at prices[3] = 8
Buying at prices[4] = 4
Selling at prices[5] = 9
The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
 * @author superball
 * @time 2018年1月17日上午12:45:01
 */
public class DP_714 {
	public static void main(String[] args) {
		DP_714 main = new DP_714();
		System.out.println(main.maxProfit(new int[] { 1, 3, 2, 8, 4, 9 }, 2));
	}

	public int maxProfit(int[] prices, int fee) {
		int cash = 0;
		int hold = -prices[0];
		for (int i = 1; i < prices.length; i++) {
			int temp = cash;
			cash = Math.max(cash, hold + prices[i] - fee);
			hold = Math.max(hold, temp - prices[i]);
		}
		return cash;
	}
}
