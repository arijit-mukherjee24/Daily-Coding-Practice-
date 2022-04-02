package com.dp.knapsack.bounded;

import java.util.HashMap;

// 494. Target Sum

//Sahil DP: Day 5
//TC: O(n*target)  SC:  O(n*target) 
public class Target_Sum {

	public static void main(String[] args) {

	}

	public int findTargetSumWays(int[] nums, int target) {
		return totalWays(nums, 0, target, new HashMap<String, Integer>());
	}

	private int totalWays(int[] nums, int currentIndex, int target, HashMap<String, Integer> memo) {

		if (currentIndex == nums.length && target == 0)
			return 1;

		if (currentIndex == nums.length && target != 0)
			return 0;

		String currentKey = Integer.toString(currentIndex) + "-" + Integer.toString(target);

		if (memo.containsKey(currentKey)) {
			return memo.get(currentKey);
		}

		int posSign = totalWays(nums, currentIndex + 1, target - nums[currentIndex], memo);
		int negSign = totalWays(nums, currentIndex + 1, target + nums[currentIndex], memo);

		memo.put(currentKey, posSign + negSign);
		return memo.get(currentKey);
	}

}
