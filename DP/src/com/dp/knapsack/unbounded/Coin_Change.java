package com.dp.knapsack.unbounded;
// 322. Coin Change

//Sahil DP-day7
//TC: O(coins.length*amount) SC: O(coins.length*amount)
import java.util.HashMap;

public class Coin_Change {

	public static void main(String[] args) {

	}

	public int coinChange(int[] coins, int amount) {
		int ans = minCoins(coins, 0, amount, new HashMap<String, Integer>());

		if (ans == 10001)
			return -1;

		return ans;
	}

	private int minCoins(int[] coins, int currentIndex, int amount, HashMap<String, Integer> memo) {

		if (amount == 0)
			return 0; // No coins required to make up a amount = 0

		if (currentIndex == coins.length)
			return 10001; // from the constraint hightest value

		String currentKey = Integer.toString(currentIndex) + "-" + Integer.toString(amount);
		if (memo.containsKey(currentKey))
			return memo.get(currentKey);

		int currentCoin = coins[currentIndex];

		int consider = 10001;

		if (currentCoin <= amount) {
			consider = 1 + minCoins(coins, currentIndex, amount - currentCoin, memo);
		}

		int notConsider = minCoins(coins, currentIndex + 1, amount, memo);

		memo.put(currentKey, Math.min(consider, notConsider));
		return Math.min(consider, notConsider);

	}

}
