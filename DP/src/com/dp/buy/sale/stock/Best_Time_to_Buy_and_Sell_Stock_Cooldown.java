package com.dp.buy.sale.stock;

import java.util.HashMap;

// 309. Best Time to Buy and Sell Stock with Cooldown

//Sahil: Day 8 (DP)
//TC: O(prices.length * 2 (canBuy))   SC: O(prices.length * 2 (canBuy) )

public class Best_Time_to_Buy_and_Sell_Stock_Cooldown {

	public static void main(String[] args) {

	}

	public int maxProfit(int[] prices) {
		return maximumProfit(prices, 0, 1, new HashMap<String, Integer>());
	}

	private int maximumProfit(int[] prices, int currentDay, int canBuy, HashMap<String, Integer> memo) {

		if (currentDay >= prices.length)
			return 0;

		String currentKey = currentDay + "-" + canBuy;

		if (memo.containsKey(currentKey)) {
			return memo.get(currentKey);
		}

		int ans = 0;

		if (canBuy == 1) {
			int idle = maximumProfit(prices, currentDay + 1, canBuy, memo);
			int buy = -prices[currentDay] + maximumProfit(prices, currentDay + 1, 0, memo);
			ans = Math.max(idle, buy);
		} else {
			int idle = maximumProfit(prices, currentDay + 1, canBuy, memo);
			int sell = prices[currentDay] + maximumProfit(prices, currentDay + 2, 1, memo);
			ans = Math.max(idle, sell);
		}

		memo.put(currentKey, ans);
		return ans;
	}

}
