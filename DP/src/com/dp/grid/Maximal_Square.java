package com.dp.grid;

import java.util.HashMap;

// 221. Maximal Square

//Sahil : DP Day(12)
//Hint 1: Square can start from any cell which contains 1
//Hint 2: Run maximalSquare func for all cell with value = 1
//Hint 3: Expand square from length 1 to length 2 : Down, Right Diagonal, Right

//TC: O(m^2 * n^2) ~ O(m *n^2) ~ O(m * n)   SC: O(m*n)

public class Maximal_Square {

	public static void main(String[] args) {

	}

	public int maximalSquare(char[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;

		HashMap<String, Integer> memo = new HashMap<>();
		int area = 0;
		for (int currentRow = 0; currentRow < m; currentRow++) {
			for (int currentCol = 0; currentCol < n; currentCol++) {

				if (matrix[currentRow][currentCol] == '1') {
					int sideLength = maximumSize(matrix, currentRow, currentCol, m, n, memo);
					area = Math.max(area, sideLength * sideLength);
				}
			}
		}
		return area;
	}

	private int maximumSize(char[][] matrix, int currentRow, int currentCol, int m, int n,
			HashMap<String, Integer> memo) {

		if (currentRow < 0 || currentRow >= m || currentCol < 0 || currentCol >= n
				|| matrix[currentRow][currentCol] == '0')
			return 0;

		String currentKey = currentRow + "-" + currentCol;
		if (memo.containsKey(currentKey))
			return memo.get(currentKey);

		int rightExpansion = 1 + maximumSize(matrix, currentRow, currentCol + 1, m, n, memo);
		int downExpansion = 1 + maximumSize(matrix, currentRow + 1, currentCol, m, n, memo);
		int rightDiagExpansion = 1 + maximumSize(matrix, currentRow + 1, currentCol + 1, m, n, memo);

		memo.put(currentKey, Math.min(rightExpansion, Math.min(downExpansion, rightDiagExpansion)));
		return memo.get(currentKey);
	}

}
