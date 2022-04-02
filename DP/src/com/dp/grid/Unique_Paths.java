package com.dp.grid;

import java.util.HashMap;

// 62. Unique Paths

//Sahil: DP( Day - 11)
//TC: 2^(m*n)   SC: O(max(m, n))  Recursive Approach
//TC: O(m*n)   SC: O(m*n)
public class Unique_Paths {

	public static void main(String[] args) {

	}

	public int uniquePaths(int m, int n) {
		return totalWays(0, 0, m, n, new HashMap<String, Integer>());
	}

	private int totalWays(int currentRow, int currentCol, int m, int n, HashMap<String, Integer> memo) {

		if (currentRow == m - 1 && currentCol == n - 1)
			return 1; // Destination

		if (currentRow >= m || currentCol >= n)
			return 0; // Invalid Cell

		String currentKey = currentRow + "-" + currentCol;
		if (memo.containsKey(currentKey))
			return memo.get(currentKey);

		int rightMove = totalWays(currentRow, currentCol + 1, m, n, memo);
		int downMove = totalWays(currentRow + 1, currentCol, m, n, memo);

		memo.put(currentKey, rightMove + downMove);
		return rightMove + downMove;
	}

}
