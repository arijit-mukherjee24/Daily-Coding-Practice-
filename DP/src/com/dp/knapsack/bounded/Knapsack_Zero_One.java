package com.dp.knapsack.bounded;

import java.util.HashMap;

// 0 - 1 Knapsack Problem -  https://practice.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1

//Sahil DP(Day - 3)
//TC: O(2^n)  SC: O(n)  Recursion
//TC: O(W * N)        SC : O(W * N)  
public class Knapsack_Zero_One {

	public static void main(String[] args) {

	}

	// Function to return max value that can be put in knapsack of capacity W.
	static int knapSack(int W, int wt[], int val[], int n) {
		// your code here
		return maxProfit(wt, val, 0, W, n, new HashMap<String, Integer>());
	}

	private static int maxProfit(int[] wt, int[] profit, int currentItem, int capacity, int n,
			HashMap<String, Integer> memo) {

		if (currentItem == n)
			return 0;

		int currentItemWeight = wt[currentItem];
		int currentItemProfit = profit[currentItem];

		String currentKey = currentItem + "-" + capacity;
		if (memo.containsKey(currentKey))
			return memo.get(currentKey);

		int consider = 0;
		if (currentItemWeight <= capacity) {
			consider = currentItemProfit
					+ maxProfit(wt, profit, currentItem + 1, capacity - currentItemWeight, n, memo);
		}

		int notConsider = maxProfit(wt, profit, currentItem + 1, capacity, n, memo);

		memo.put(currentKey, Math.max(consider, notConsider));
		return Math.max(consider, notConsider);
	}

}
