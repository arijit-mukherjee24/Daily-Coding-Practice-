package com.dp.knapsack.bounded;

import java.util.HashMap;

//https://leetcode.com/problems/partition-equal-subset-sum/
//Sahil DP(Day - 3)

// Subset Sum Problem - https://practice.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1/
public class SubsetSum {

	public static void main(String[] args) {

	}

	static Boolean isSubsetSum(int N, int nums[], int sum) {
		// code here
		return isPossible(nums, 0, sum, new HashMap<String, Boolean>());
	}

	private static boolean isPossible(int[] nums, int currentIndex, int targetSum, HashMap<String, Boolean> memo) {

		if (targetSum == 0)
			return true;

		if (currentIndex >= nums.length)
			return false;

		String currentKey = currentIndex + "-" + targetSum;
		if (memo.containsKey(currentKey))
			memo.get(currentKey);

		boolean consider = false;
		if (nums[currentIndex] <= targetSum) {
			consider = isPossible(nums, currentIndex + 1, targetSum - nums[currentIndex], memo);
			if (consider)
				return true;
		}

		boolean notConsider = isPossible(nums, currentIndex + 1, targetSum, memo);

		memo.put(currentKey, consider || notConsider);
		return (consider || notConsider);
	}

}
