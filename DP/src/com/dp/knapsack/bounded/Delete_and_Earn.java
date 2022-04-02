package com.dp.knapsack.bounded;

import java.util.Arrays;
import java.util.HashMap;

// 740. Delete and Earn

//Sahil DP - Day 5 & Day 6(code part)
//TC: O(n)  SC: O(n)
public class Delete_and_Earn {

	public static void main(String[] args) {

	}

	public int deleteAndEarn(int[] nums) {
		int max = Arrays.stream(nums).max().getAsInt();
		int[] freq = new int[max + 1];

		for (int e : nums) {
			freq[e]++;
		}

		HashMap<Integer, Integer> memo = new HashMap<>();
		return maxPoint(freq, 0, memo);
	}

	private int maxPoint(int[] freq, int currentIndex, HashMap<Integer, Integer> memo) {
		if (currentIndex >= freq.length)
			return 0;

		int currentKey = currentIndex;
		if (memo.containsKey(currentKey))
			return memo.get(currentKey);

		int del = currentIndex * freq[currentIndex] + maxPoint(freq, currentIndex + 2, memo);
		int noDel = maxPoint(freq, currentIndex + 1, memo);

		memo.put(currentKey, Math.max(del, noDel));
		return memo.get(currentKey);
	}

}
