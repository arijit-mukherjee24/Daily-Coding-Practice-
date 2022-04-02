package com.dp.knapsack.bounded;

import java.util.HashMap;

public class Count_Subset_with_a_given_diff {

	public static void main(String[] args) {
		int arr[] = { 3, 3, 3, 3 };
		int x = 6;

		System.out.println(noOfPartition(arr, x));
	}

	public static int noOfPartition(int[] nums, int target) {
		return noOfPossible(nums, 0, target, new HashMap<String, Integer>());
	}

	private static int noOfPossible(int[] nums, int currentIndex, int targetSum, HashMap<String, Integer> memo) {

		if (targetSum == 0)
			return 1;

		if (currentIndex >= nums.length)
			return 0;

		String currentKey = currentIndex + "-" + targetSum;
		if (memo.containsKey(currentKey))
			memo.get(currentKey);

		int consider = 0;
		if (nums[currentIndex] <= targetSum) {
			consider = noOfPossible(nums, currentIndex + 1, targetSum - nums[currentIndex], memo);
		}

		int notConsider = noOfPossible(nums, currentIndex + 1, targetSum, memo);

		memo.put(currentKey, consider + notConsider);
		return consider + notConsider;
	}

}
