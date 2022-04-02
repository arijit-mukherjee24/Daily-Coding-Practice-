package com.dp.knapsack.unbounded;

// Knapsack with Duplicate Items - https://practice.geeksforgeeks.org/problems/knapsack-with-duplicate-items4201/1

//TC: O(N*W) SC: O(N*W) Sahil DP-day7
import java.util.HashMap;

public class Knapsack_with_Duplicate_Items {

	public static void main(String[] args) {

	}

	static int knapSack(int N, int W, int val[], int wt[]) {
		// code here
		int[][] dp = new int[N][W + 1];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < W + 1; j++)
				dp[i][j] = -1;

		return maxProfit(wt, val, 0, W, N, dp);
	}

	private static int maxProfit(int[] wt, int[] val, int currentItem, int W, int N, int[][] dp) {

		if (W == 0)
			return 0;

		if (currentItem == N)
			return 0;

		int currentItemWeight = wt[currentItem];
		int currentItemProfit = val[currentItem];

		// String currentKey = Integer.toString(currentItem) + "-" +
		// Integer.toString(W);
		// if(memo.containsKey(currentKey)) {
		// return memo.get(currentKey);
		// }

		if (dp[currentItem][W] != -1)
			return dp[currentItem][W];

		int consider = 0;

		if (currentItemWeight <= W)
			consider = currentItemProfit + maxProfit(wt, val, currentItem, W - currentItemWeight, N, dp);

		int notConsider = maxProfit(wt, val, currentItem + 1, W, N, dp);

		// memo.put(currentKey, Math.max(consider, notConsider));
		// return memo.get(currentKey);

		dp[currentItem][W] = Math.max(consider, notConsider);
		return dp[currentItem][W];
	}

}
