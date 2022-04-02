package com.dp.grid;

import java.util.HashMap;

// 64. Minimum Path Sum

//Sahil: DP( Day - 11)
//TC: O(m*n)   SC: O(m*n)

// Probable Similar Question:
// Maximum decimal value path in a binary matrix (GFG: https://www.geeksforgeeks.org/maximum-decimal-value-path-in-a-binary-matrix/) Try

public class Minimum_Path_Sum {

	public static void main(String[] args) {

	}

	public int minPathSum(int[][] grid) {
		return minSum(grid, 0, 0, grid.length, grid[0].length, new HashMap<String, Integer>());
	}

	private int minSum(int[][] grid, int currentRow, int currentCol, int m, int n, HashMap<String, Integer> memo) {

		if (currentRow == m - 1 && currentCol == n - 1)
			return grid[currentRow][currentCol];

		if (currentRow >= m || currentCol >= n)
			return 10001;

		String currentKey = currentRow + "-" + currentCol;
		if (memo.containsKey(currentKey))
			return memo.get(currentKey);

		int downMove = grid[currentRow][currentCol] + minSum(grid, currentRow + 1, currentCol, m, n, memo);
		int rightMove = grid[currentRow][currentCol] + minSum(grid, currentRow, currentCol + 1, m, n, memo);

		memo.put(currentKey, Math.min(downMove, rightMove));
		return Math.min(downMove, rightMove);
	}

}
