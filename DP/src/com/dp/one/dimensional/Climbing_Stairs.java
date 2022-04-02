package com.dp.one.dimensional;

import java.util.HashMap;

// 70. Climbing Stairs

//sahil - DP 1
//TC: O(2^n)  SC: O(n+1) ~ O(n)  Only Recursion
//TC: O(n)  SC:  DP
public class Climbing_Stairs {

	public static void main(String[] args) {

	}

	public int climbStairs(int n) {
		return totalWays(0, n, new HashMap<Integer, Integer>());
	}

	private int totalWays(int currentStair, int targetStair, HashMap<Integer, Integer> memo) {

		// base condition
		if (currentStair == targetStair)
			return 1;

		if (currentStair > targetStair)
			return 0;

		// Dp part
		int currentKey = currentStair;
		if (memo.containsKey(currentKey)) {
			return memo.get(currentKey);
		}

		int oneJump = totalWays(currentStair + 1, targetStair, memo);
		int twoJump = totalWays(currentStair + 2, targetStair, memo);

		memo.put(currentStair, oneJump + twoJump);
		return (oneJump + twoJump);
	}

}
