package com.dp.catalan.application;

//96. Unique Binary Search Trees

//https://www.youtube.com/watch?v=OIc0mHgHUww Techdose
//Using Catalan Number Formula

//Sahil Dp Day9 Recursion Catalan No
public class Unique_Binary_Search_Trees {

	public static void main(String[] args) {

	}

	public int numTrees(int n) {
		int catalan[] = new int[n + 1];

		catalan[0] = catalan[1] = 1;

		for (int i = 2; i <= n; i++) {
			catalan[i] = 0;
			for (int j = 0; j < i; j++) {
				catalan[i] += catalan[j] * catalan[i - j - 1];
			}

		}
		return catalan[n];

	}

}
