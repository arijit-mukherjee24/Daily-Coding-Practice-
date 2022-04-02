package com.dp.lcs;

import java.util.HashMap;

// 1143. Longest Common Subsequence

//Sahil DP: Day(14)
//Total no subsequences : n^2
//Total no substring: n(n+1)/2

//TC:O(2^(min(s1.length(), s2.length())))    SC: O(Math.min(s1.length(), s2.length())) Recu
//TC: O(s1.length() * s2.length())  SC: O(s1.length() * s2.length())

public class Longest_Common_Subsequence {

	public static void main(String[] args) {

	}

	public int longestCommonSubsequence(String s1, String s2) {
		return lengthOfLCS(s1, s2, 0, 0, s1.length(), s2.length(), new HashMap<String, Integer>());
	}

	private int lengthOfLCS(String s1, String s2, int i, int j, int m, int n, HashMap<String, Integer> memo) {

		if (i >= m || j >= n)
			return 0;

		int ans = 0;

		String currentKey = i + "-" + j;
		if (memo.containsKey(currentKey))
			return memo.get(currentKey);

		if (s1.charAt(i) == s2.charAt(j)) {
			ans = 1 + lengthOfLCS(s1, s2, i + 1, j + 1, m, n, memo);
		} else {
			int a = lengthOfLCS(s1, s2, i, j + 1, m, n, memo);
			int b = lengthOfLCS(s1, s2, i + 1, j, m, n, memo);

			ans = Math.max(a, b);
		}

		memo.put(currentKey, ans);
		return ans;
	}

}
