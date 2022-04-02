package com.dp.lcs;
// 516. Longest Palindromic Subsequence

//Sahil DP: Day(14)
//Total no subsequences : n^2
//Total no substring: n(n+1)/2

//TC:O(2^(min(s1.length(), s2.length())))    SC: O(Math.min(s1.length(), s2.length())) Recu
//TC: O(s1.length() * s2.length())  SC: O(s1.length() * s2.length())
public class Longest_Palindromic_Subsequence {

	public static void main(String[] args) {
		
	}

	public int longestPalindromeSubseq(String s) {
		String rev = new StringBuffer(s).reverse().toString();

		int[][] dp = new int[s.length()][s.length()];
		for (int i = 0; i < s.length(); i++)
			for (int j = 0; j < s.length(); j++)
				dp[i][j] = -1;

		return lengthOfLCS(s, rev, 0, 0, s.length(), s.length(), dp);
	}

	private int lengthOfLCS(String s1, String s2, int i, int j, int m, int n, int[][] dp) {

		if (i >= m || j >= n)
			return 0;

		int ans = 0;

		if (dp[i][j] != -1)
			return dp[i][j];

		if (s1.charAt(i) == s2.charAt(j)) {
			ans = 1 + lengthOfLCS(s1, s2, i + 1, j + 1, m, n, dp);
		} else {
			int a = lengthOfLCS(s1, s2, i, j + 1, m, n, dp);
			int b = lengthOfLCS(s1, s2, i + 1, j, m, n, dp);

			ans = Math.max(a, b);
		}

		dp[i][j] = ans;
		return ans;
	}

}
