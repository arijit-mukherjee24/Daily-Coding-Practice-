package com.dp.knapsack.bounded;

import java.util.HashMap;

// 1155. Number of Dice Rolls With Target Sum

//Sahil : DP Day(13)
//TC:  O(k^n)  SC: O(n)        Recursive Approach d=n=no of dice and f=k=no of faces
//TC:  O(d * target * f)        SC: O(d * target)      Memo
public class Number_of_Dice_Rolls_With_Target_Sum {

	public static void main(String[] args) {

	}

	public int numRollsToTarget(int d, int f, int target) {
		return totalWays(d, f, target, new HashMap<String, Integer>());
	}

	private int totalWays(int n, int f, int targetSum, HashMap<String, Integer> memo) {

		if (n == 0 && targetSum == 0)
			return 1;

		if (n == 0 || targetSum <= 0)
			return 0;

		String currentKey = n + "-" + targetSum;
		if (memo.containsKey(currentKey))
			return memo.get(currentKey);

		int ways = 0;
		int MOD = 1000000007;

		// (a + b) % c = (a % c + b % c) % c Modulus operation
		for (int i = 1; i <= f; i++) {
			int tempAns = totalWays(n - 1, f, targetSum - i, memo) % MOD;
			ways = ways % MOD;

			ways = (ways + tempAns) % MOD;
		}

		memo.put(currentKey, ways);
		return ways;
	}

}
