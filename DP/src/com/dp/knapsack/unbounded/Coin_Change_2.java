package com.dp.knapsack.unbounded;

import java.util.HashMap;

// 518. Coin Change 2

//Sahil DP-day7
//TC: O(coins.length*amount) SC: O(coins.length*amount)
public class Coin_Change_2 {

	public static void main(String[] args) {

	}

	public int change(int amount, int[] coins) {
		return totalWays(coins, 0, amount, new HashMap<String, Integer>());
	}

	private int totalWays(int[] coins, int currentIndex, int amount, HashMap<String, Integer> memo) {

		if (amount == 0)
			return 1;

		if (currentIndex >= coins.length)
			return 0;

		String currentKey = Integer.toString(currentIndex) + "-" + Integer.toString(amount);
		if (memo.containsKey(currentKey)) {
			return memo.get(currentKey);
		}

		int currentCoin = coins[currentIndex];
		int consider = 0;

		if (currentCoin <= amount)
			consider = totalWays(coins, currentIndex, amount - currentCoin, memo);

		int notConsider = totalWays(coins, currentIndex + 1, amount, memo);

		memo.put(currentKey, consider + notConsider);
		return memo.get(currentKey);
	}

}
