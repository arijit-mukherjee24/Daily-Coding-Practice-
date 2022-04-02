package com.dp.jump.game;

// 45. Jump Game II

//DP Approach: TLE
//Sahil - DP (Day 9)
//TC: O(n * max(nums[i]))  SC: O(n * max(nums[i]))
import java.util.HashMap;

public class Jump_Game_II {

	public static void main(String[] args) {

	}

	public int jump(int[] nums) {
		return minJumps(nums, 0, new HashMap<Integer, Integer>());
	}

	private int minJumps(int[] nums, int currentIndex, HashMap<Integer, Integer> memo) {

		if (currentIndex >= nums.length - 1)
			return 0; // If we reach the last index, we don't need any jump

		if (nums[currentIndex] == 0)
			return 10001; // If jump is not possible at a particular index, then a INT_MAX value or
							// constraint highest value

		int currentKey = currentIndex;
		if (memo.containsKey(currentKey))
			return memo.get(currentKey);

		int currentJumps = nums[currentIndex];
		int ans = 10001;

		for (int x = 1; x <= currentJumps; x++) {
			int tempAns = 1 + minJumps(nums, currentIndex + x, memo);
			ans = Math.min(ans, tempAns);
		}

		memo.put(currentKey, ans);
		return ans;
	}

}
