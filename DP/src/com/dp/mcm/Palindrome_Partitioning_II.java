package com.dp.mcm;

import java.util.HashMap;

// 132. Palindrome Partitioning II

//Sahil : DP Day(13) mcm
//TC: O(n*n *n)  SC: O(n)
//start can go upto n
//for ... n
//isPalindrome ... n
//So, O(n * n *n)
public class Palindrome_Partitioning_II {

	public static void main(String[] args) {

	}

	public int minCut(String s) {
		return minimumCuts(s, 0, s.length() - 1, new HashMap<String, Integer>());
	}

	private int minimumCuts(String s, int start, int end, HashMap<String, Integer> memo) {

		if (isPalindrome(s, start, end))
			return 0;

		int ans = 1000000;

		String currentKey = Integer.toString(start);
		if (memo.containsKey(currentKey))
			return memo.get(currentKey);

		// start, start+1, start+2, ..... end-1
		for (int i = start; i < end; i++) {
			if (isPalindrome(s, start, i)) {
				int tempAns = 1 + minimumCuts(s, i + 1, end, memo);
				ans = Math.min(ans, tempAns);
			}
		}

		memo.put(currentKey, ans);
		return ans;
	}

	private boolean isPalindrome(String s, int start, int end) {

		while (start <= end) {
			if (s.charAt(start) != s.charAt(end))
				return false;

			start++;
			end--;
		}
		return true;
	}

}
