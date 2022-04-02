package com.dp.jump.game;

// 55. Jump Game

//DP Approach: TLE
//Sahil - DP (Day 9)
//TC: O(n * max(nums[i]))  SC: O(n * max(nums[i]))
import java.util.HashMap;

public class Jump_Game {

	public static void main(String[] args) {

	}

	public boolean canJump(int[] nums) {
		return isPossible(nums, 0, new HashMap<Integer, Boolean>());
	}

	private boolean isPossible(int[] nums, int currentIndex, HashMap<Integer, Boolean> memo) {

		if (currentIndex >= nums.length - 1)
			return true;

		int currentKey = currentIndex;
		if (memo.containsKey(currentKey))
			return memo.get(currentKey);

		int currentJumps = nums[currentIndex];

		boolean ans = false;
		for (int x = 1; x <= currentJumps; x++) {
			boolean tempAns = isPossible(nums, currentIndex + x, memo);
			ans = ans | tempAns;
		}

		memo.put(currentKey, ans);
		return ans;
	}

}
