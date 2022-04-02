package com.dp.one.dimensional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//Sahil : DP(2)
//TC:O(n)  SC:O(n)

// 213. House Robber II
public class House_Robber_II {

	public static void main(String[] args) {

	}

	public int rob(int[] nums) {
		int n = nums.length;
		if (n == 1)
			return nums[0];

		List<Integer> temp1 = new ArrayList<>();
		List<Integer> temp2 = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			if (i != 0)
				temp1.add(nums[i]);
			if (i != n - 1)
				temp2.add(nums[i]);
		}

		return Math.max(maxRobAmt(temp1, 0, new HashMap<Integer, Integer>()),
				maxRobAmt(temp2, 0, new HashMap<Integer, Integer>()));
	}

	private int maxRobAmt(List<Integer> nums, int currentIndex, HashMap<Integer, Integer> memo) {
		if (currentIndex >= nums.size())
			return 0;

		int currentKey = currentIndex;
		if (memo.containsKey(currentKey)) {
			return memo.get(currentKey);
		}

		int rob = nums.get(currentIndex) + maxRobAmt(nums, currentIndex + 2, memo);
		int noRob = maxRobAmt(nums, currentIndex + 1, memo);

		memo.put(currentKey, Math.max(rob, noRob));
		return memo.get(currentKey);
	}

}
