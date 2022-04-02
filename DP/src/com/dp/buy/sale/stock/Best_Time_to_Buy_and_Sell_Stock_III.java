package com.dp.buy.sale.stock;

// 123. Best Time to Buy and Sell Stock III

//Sahil: Day 8 (DP)
//TC: O(prices.length * 2 (canBuy) * no of transaction=2)   SC: O(prices.length * 2 (canBuy) * no of transaction=2)

public class Best_Time_to_Buy_and_Sell_Stock_III {

	public static void main(String[] args) {

	}

	public int maxProfit(int[] prices) {

		int[][][] dp = new int[prices.length + 1][2 + 1][2 + 1];
		for (int i = 0; i < prices.length + 1; i++) {
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 3; k++) {
					dp[i][j][k] = -1;
				}
			}
		}
		// return maximumProfit(prices, 0, 1, 2, new HashMap<String, Integer>());
		return maximumProfit(prices, 0, 1, 2, dp);
	}

	private int maximumProfit(int[] prices, int currentDay, int canBuy, int transCount, int[][][] dp) {

		if (currentDay >= prices.length || transCount == 0)
			return 0;

		// String currentKey = currentDay + "-" + canBuy + "-" + transCount;

		// if(memo.containsKey(currentKey)) {
		// return memo.get(currentKey);
		// }

		if (dp[currentDay][canBuy][transCount] != -1)
			return dp[currentDay][canBuy][transCount];

		int ans = 0;

		if (canBuy == 1) {
			int idle = maximumProfit(prices, currentDay + 1, canBuy, transCount, dp);
			int buy = -prices[currentDay] + maximumProfit(prices, currentDay + 1, 0, transCount, dp);
			ans = Math.max(idle, buy);
		} else {
			int idle = maximumProfit(prices, currentDay + 1, canBuy, transCount, dp);
			int sell = prices[currentDay] + maximumProfit(prices, currentDay + 1, 1, transCount - 1, dp);
			ans = Math.max(idle, sell);
		}

		dp[currentDay][canBuy][transCount] = ans;
		return ans;
	}

}
