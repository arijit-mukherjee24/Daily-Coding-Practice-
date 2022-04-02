package com.dp.one.dimensional;

import java.util.HashMap;

// 746. Min Cost Climbing Stairs

//Sahil: DP-2
//TC: O(n) SC: O(n)
public class Min_Cost_Climbing_Stairs {

	public static void main(String[] args) {

	}

	public int minCostClimbingStairs(int[] cost) {
		HashMap<Integer, Integer> memo = new HashMap<>();
		return Math.min(minCost(cost, 0, memo), minCost(cost, 1, memo));
	}

	private int minCost(int[] cost, int currentIndex, HashMap<Integer, Integer> memo) {

		// top of the floor, so above the array, so cost.length
		if (currentIndex == cost.length)
			return 0;

		// from the constraint : 0 <= cost[i] <= 999
		if (currentIndex > cost.length)
			return 1001;

		int currentKey = currentIndex;

		if (memo.containsKey(currentKey)) {
			return memo.get(currentKey);
		}

		int oneJump = cost[currentIndex] + minCost(cost, currentIndex + 1, memo);
		int twoJump = cost[currentIndex] + minCost(cost, currentIndex + 2, memo);

		memo.put(currentKey, Math.min(oneJump, twoJump));

		return memo.get(currentKey);
	}

}
