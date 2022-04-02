package com.dp.knapsack.unbounded;
// Rod Cutting - https://practice.geeksforgeeks.org/problems/rod-cutting0840/1/

//Sahil DP ( Day 7)
//Unbounded Knapsack
//TC: O(n^2) SC: O(n^2)
import java.util.HashMap;

public class Rod_Cutting {

	public static void main(String[] args) {

	}

	public int cutRod(int price[], int n) {
		// code here
		return maxProfit(price, 0, n, new HashMap<String, Integer>());
	}

	private static int maxProfit(int[] price, int currentIndex, int len, HashMap<String, Integer> memo) {

		if (len == 0)
			return 0; // If length of the rod is zero, max profit we can get is 0

		if (currentIndex >= price.length)
			return 0; // Don't have any pieces left to process

		String currentKey = currentIndex + "-" + len;

		if (memo.containsKey(currentKey))
			return memo.get(currentKey);

		int currentPieceLength = currentIndex + 1;
		int consider = 0;

		if (currentPieceLength <= len)
			consider = price[currentIndex] + maxProfit(price, currentIndex, len - currentPieceLength, memo);

		int notConsider = maxProfit(price, currentIndex + 1, len, memo);

		memo.put(currentKey, Math.max(consider, notConsider));
		return Math.max(consider, notConsider);
	}

}
