package com.dp.knapsack.bounded;

import java.util.Arrays;
import java.util.HashMap;

// 416. Partition Equal Subset Sum

//Sahil DP(Day - 3)
//Hint: We need to find a subset, for which sum = sum/2;
public class Partition_Equal_Subset_Sum {

	public static void main(String[] args) {

	}

	public boolean canPartition(int[] nums) {
		int sum = Arrays.stream(nums).sum();

		if (sum % 2 == 1)
			return false;

		return isPossible(nums, 0, sum / 2, new HashMap<String, Boolean>());
	}

	private boolean isPossible(int[] nums, int currentIndex, int targetSum, HashMap<String, Boolean> memo) {

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
