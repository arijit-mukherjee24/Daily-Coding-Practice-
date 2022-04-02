package com.dp.buy.sale.stock;

import java.util.HashMap;

// 714. Best Time to Buy and Sell Stock with Transaction Fee

//Sahil: Day 8 (DP)
//TC: O(prices.length * 2 (canBuy) )   SC: O(prices.length * 2 (canBuy))

//Here, we do not need to pass the transaction
public class Best_Time_to_Buy_and_Sell_Stock_Fine_Transaction {

	public static void main(String[] args) {

	}

	public int maxProfit(int[] prices, int fee) {
		return maximumProfit(prices, 0, 1, 1, new HashMap<String, Integer>(), fee);
	}

	private int maximumProfit(int[] prices, int currentDay, int canBuy, int transCount, HashMap<String, Integer> memo,
			int fee) {

		if (currentDay >= prices.length)
			return 0;

		String currentKey = currentDay + "-" + canBuy;

		if (memo.containsKey(currentKey)) {
			return memo.get(currentKey);
		}

		int ans = 0;

		if (canBuy == 1) {
			int idle = maximumProfit(prices, currentDay + 1, canBuy, transCount, memo, fee);
			int buy = -prices[currentDay] + maximumProfit(prices, currentDay + 1, 0, transCount, memo, fee);
			ans = Math.max(idle, buy);
		} else {
			int idle = maximumProfit(prices, currentDay + 1, canBuy, transCount, memo, fee);
			// while selling, then only we complete a transaction, so we need to pay the fee
			int sell = -fee + prices[currentDay] + maximumProfit(prices, currentDay + 1, 1, transCount - 1, memo, fee);
			ans = Math.max(idle, sell);
		}

		memo.put(currentKey, ans);
		return ans;
	}

}
