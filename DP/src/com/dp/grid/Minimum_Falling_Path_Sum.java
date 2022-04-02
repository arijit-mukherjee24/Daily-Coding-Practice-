package com.dp.grid;

import java.util.HashMap;

// 931. Minimum Falling Path Sum

//Sahil DP(12)
//Hint: (row, col) will be (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1)

//TC: O(n*3^(m*n))  SC: O(m)  where m=no of rows and n=no of cols (Recusive soln)
//TC: O(n *(m*n))  SC: O(m*n) where m=no of rows and n=no of cols (DP)
public class Minimum_Falling_Path_Sum {

	public static void main(String[] args) {

	}

	public int minFallingPathSum(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;

		int ans = Integer.MAX_VALUE;
		HashMap<String, Integer> memo = new HashMap<>();
		for (int currentCol = 0; currentCol < n; currentCol++) {
			int tempAns = minPathSum(matrix, 0, currentCol, m, n, memo);
			ans = Math.min(ans, tempAns);
		}

		return ans;
	}

	private int minPathSum(int[][] matrix, int currentRow, int currentCol, int m, int n,
			HashMap<String, Integer> memo) {

		if (currentCol < 0 || currentCol >= n)
			return 100001;

		if (currentRow == m - 1)
			return matrix[currentRow][currentCol];

		String currentKey = currentRow + "-" + currentCol;
		if (memo.containsKey(currentKey)) {
			return memo.get(currentKey);
		}

		int leftDiagonal = matrix[currentRow][currentCol]
				+ minPathSum(matrix, currentRow + 1, currentCol - 1, m, n, memo);
		int down = matrix[currentRow][currentCol] + minPathSum(matrix, currentRow + 1, currentCol, m, n, memo);
		int rightDiagonal = matrix[currentRow][currentCol]
				+ minPathSum(matrix, currentRow + 1, currentCol + 1, m, n, memo);

		memo.put(currentKey, Math.min(leftDiagonal, Math.min(down, rightDiagonal)));
		return Math.min(leftDiagonal, Math.min(down, rightDiagonal));

	}

}
